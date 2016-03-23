package hu.schonhertz.training.blog.web;

import java.util.ArrayList;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MockData {

	public static UserVO findUserAndRolesByName(String username) {

		ArrayList<RoleVO> roles = new ArrayList<>();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String password = null;

		if (username.equals("user")) {
			password = bCryptPasswordEncoder.encode("user");
			roles.add(new RoleVO("ROLE_USER"));
		} else if (username.equals("blogger")) {
			password = bCryptPasswordEncoder.encode("blogger");
			roles.add(new RoleVO("ROLE_USER"));
			roles.add(new RoleVO("ROLE_BLOGGER"));
		} else {
			return null;
		}

		UserVO userVO = new UserVO();
		userVO.setUserName(username);
		userVO.setPassword(password);
		userVO.setRoles(roles);

		return userVO;
	}

}
