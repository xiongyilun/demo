package com.example.mapper;

        import java.util.List;
        import com.example.bean.User;
        import org.apache.ibatis.annotations.Param;
        import org.apache.ibatis.annotations.Select;


public interface UserMapper {

    @Select("select * from t_user where 1=1")
    List<User> findAll();

    @Select("select * from t_user where id = #{userId}")
    User getOne(Integer userId);
    
    @Select("select * from t_user where username = #{username} and sex = #{password}")
    User get(@Param("username") String username, @Param("password") String password);

}
