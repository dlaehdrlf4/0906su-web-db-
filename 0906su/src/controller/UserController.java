package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import service.UserService;
import service.UserServiceImpl;
import vo.FMember;


@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
    public UserController() {
        super();
      userService = UserServiceImpl.sharedInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//요청 경로에서 프로젝트 경로를 제거
			String requestURI = request.getRequestURI();
			String contextPath = request.getContextPath(); // contextPath 프로젝트 경로 이것은 항상 webcontact가 된다.
			String command = requestURI.substring(contextPath.length()+1);
			
			//세션을 사용하는 경우가 많으므로 여기서 세션 생성
			HttpSession session = request.getSession();
			//command가 콘솔에 출력이 안되면
			//url 제대로 처리하지 못하는 것입니다.
			//form에서 전송할 때 사용할 URL과 Sevlet이 처리하는 URL이 같은지 확인
			System.out.println(command);
			RequestDispatcher dispatcher = null;
			switch(command) {
			case  "user/login":
				// 이 문장이 안나오면 링크 확인
				System.out.println("회원가입 처리");
				//서비스 메소드 호출
				FMember user = userService.login(request);
				//로그인 실패한 경우
				if(user == null) {
					session.setAttribute("user", user);
					session.setAttribute("msg", "email이나 비밀번호를 다시 확인하세요!.");
				}
				//로그인 성공
				else {
					session.setAttribute("user", user);
				}
				//로그인 성공여부에 관계없이 메인 페이지로 리다이렉트
				//현재 요청이 user/login 이므로 현재 위치는 user
				//메인으로 갈려면 user의 상위로 이동해야 합니다.
				response.sendRedirect("../");
				break;
			case "user/logout":
				//세션을 초기화
				session.invalidate();
				//시작 페이지로 리다이렉트
				response.sendRedirect("../");
				break;
			case "user/register":
				//단순 페이지 이동
				//"../디렉토리/페이지이름"
					dispatcher = request.getRequestDispatcher( "../member/register.jsp");
					dispatcher.forward(request, response);
					break;
			case "user/insert":
				boolean r = userService.registerMember(request);
				if(r == true) {
					//회원가입에 성공했을 때 처리
					session.setAttribute("msg", "가입에 성공하셨습니다.");
					response.sendRedirect("../");
				}else {
					session.setAttribute("registermsg", "회원 가입에 실패하셨습니다." );
					response.sendRedirect("/register");
					//회원가입에 실패했을 때 처리
				}
					break;
			case "user/emailcheck":
				//어떤일을 하면 무조건 서비스를 불러라
				boolean result = userService.emailCheck(request);
				//json으로 출력할 때는 리턴받은 데이터를 바로 저장하지 말고
				//JSON 객체로 변환해서 저장
				JSONObject obj = new JSONObject();
				obj.put("result", result);
				
				// 데이터를 저장
				request.setAttribute("result", obj); // obj는 키를 줘서 넣어준거고 그냥 result는 키를 말고 값을 주었다.
				//결과페이지로 포워딩 - 리다이렉트로 가능 /만 쓰면 webcontent부터 간다.
				dispatcher = request.getRequestDispatcher("/member/emailcheck.jsp");
				dispatcher.forward(request, response);
						
				
					break;
			}
			
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
