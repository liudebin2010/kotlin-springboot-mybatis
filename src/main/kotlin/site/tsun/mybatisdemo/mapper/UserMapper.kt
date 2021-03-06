package site.tsun.mybatisdemo.mapper

import org.apache.ibatis.annotations.*
import site.tsun.mybatisdemo.model.User

interface UserMapper {
    @Delete("delete from user where id=#{id}")
    fun delete(id: Int): Boolean

    @Insert("insert into user(name, email) values(#{name}, #{email})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    fun save(record: User): Int

    @Select("select * from user where id=#{id}")
    fun findUser(id: Int): User

    @Update("update user set name=#{name}, email=#{email} where id=#{id}")
    fun update(record: User): Int
}