package management.community.xiaonong.mapper;

import management.community.xiaonong.model.Admin;

public interface AdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    int insert(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    int insertSelective(Admin record);

    //登陆
    int selectByUandP(String username, String password);
}