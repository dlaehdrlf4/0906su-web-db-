package service;

import javax.servlet.http.HttpServletRequest;

import dao.UserDao;
import dao.UserDaoImpl;
import vo.FMember;

public class UserServiceImpl implements UserService {
	// 외부에서 인스턴스를 생성을 못하도록 생성자를 private으로 설정 밖에서 new를 못하는 것이다.
		
	private UserDao userDao;
	private UserServiceImpl() {
		userDao = UserDaoImpl.sharedInstance();	
		}
		//인스턴스 1개의 주소를 저장할 수 있는 변수를 생성 1개만
		private static UserService userService;
		//외부에서 인스턴스를 사용할 수 있도록 public으로 인스턴스의 주소를 리턴해주는 메소드
		public static UserService sharedInstance() {
			//그냥 리턴하면 null이니까 처음 한번만 인스턴스를 생성해주는코드이다.
			if(userService == null) {
				userService = new UserServiceImpl();
			}
			return userService;
		}
		@Override
		public FMember login(HttpServletRequest request) {
				//  파라미터 전부 읽기
				String email = request.getParameter("email");
				String pw = request.getParameter("pw");
				
				//이 메시지가 안나오는 경우는 Controller의 URL을 확인해보고 메소드 이름을 확인해야 합니다.
				// 파라미터가 잘못나오는 경우는 jsp 파일의 name과 getParamter의 이름을 확인
				//System.out.println("email:" + email );
				//System.out.println("pw:" + pw);
				// 수행할 연산이 있으면 연산을 수행
				
				// 호출할 Dao 메소드의 매개변수를 생성
				FMember member = new FMember();
				member.setEmail(email);
				member.setPw(pw);
				// Dao  메소드 호출
				FMember user = userDao.login(member);		
				// 결과 리턴
				return user;
				
			//dao에 있는 것을 서비스로 가져왔다 그리고 여기서 controller로 이동한다.
				
		}
	}

