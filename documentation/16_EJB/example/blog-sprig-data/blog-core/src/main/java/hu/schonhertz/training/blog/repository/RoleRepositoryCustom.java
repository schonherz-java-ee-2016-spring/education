package hu.schonhertz.training.blog.repository;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
public interface RoleRepositoryCustom {

	void removeRoleFromUser(Long roleId, Long userId) throws Exception;

}
