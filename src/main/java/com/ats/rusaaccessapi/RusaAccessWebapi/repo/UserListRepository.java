package com.ats.rusaaccessapi.RusaAccessWebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.UserList;
 

public interface UserListRepository extends JpaRepository<UserList, Integer>{

	 @Query(value="select * from t_user_login_rusa  where is_block=1", nativeQuery=true)
	List<UserList> getuserList();

	 @Query(value="select * from t_user_login_rusa  where is_block=:isBlock and binary user_name =:userName and binary pass =:pass", nativeQuery=true)
	UserList loginProcess(@Param("userName") String userName, @Param("pass") String pass, @Param("isBlock") int isBlock);

}
