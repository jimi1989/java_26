import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Student;
import com.kaishengit.entity.StudentExample;
import com.kaishengit.mapper.StudentMapper;
import com.kaishengit.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/7/12
 */
public class ExampleTestCase {

    Logger logger = LoggerFactory.getLogger(ExampleTestCase.class);

    private SqlSession sqlSession;
    private StudentMapper studentMapper;

    @Before
    public void before() {
        sqlSession = MybatisUtils.getSqlSession();
        // 动态代理：sqlSession对象根据接口的class动态创建接口的实现类
        // 获得接口的实现类对象
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    @After
    public void after() {
        sqlSession.close();
    }

    @Test
    public void testInsert() {
        Student student = new Student();

        student.setAddress("北京");
        student.setUserName("鲁西");
        student.setSchoolId(2);

        studentMapper.insertSelective(student);

        sqlSession.commit();
    }

    @Test
    public void testFindById() {

        Student student = studentMapper.selectByPrimaryKey(1);

        logger.debug("student:{}", student);

    }

    @Test
    public void testByExample() {
        StudentExample studentExample = new StudentExample();
       /* StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andSchoolIdEqualTo(1);
        criteria.andUserNameLike("%美丽%");*/

        studentExample.createCriteria().
                andSchoolIdEqualTo(1).
                andUserNameLike("%美丽%");

        List<Student> studentList = studentMapper.selectByExample(studentExample);

        for(Student student : studentList) {
            System.out.println(student);
        }

    }


    @Test
    public void testAll() {
        StudentExample studentExample = new StudentExample();
        // 或者筛选
       /* studentExample.or().andSchoolIdEqualTo(2);
        studentExample.or().andSchoolIdEqualTo(3);*/
       studentExample.setOrderByClause("id desc");
       studentExample.setDistinct(true);

        List<Student> studentList =  studentMapper.selectByExample(studentExample);

        for(Student student : studentList) {
            System.out.println(student);
        }

    }

    @Test
    public void testDelById() {
        studentMapper.deleteByPrimaryKey(7);

        sqlSession.commit();
    }

    @Test
    public void testDelByExample() {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andSchoolIdEqualTo(4);

        studentMapper.deleteByExample(studentExample);

        sqlSession.commit();
    }

    @Test
    public void testUpdateById() {

        Student student = studentMapper.selectByPrimaryKey(5);
        student.setId(5);
        student.setUserName("阳阳");
        studentMapper.updateByPrimaryKey(student);

        sqlSession.commit();
    }

    @Test
    public void testUpdateSelectiveById() {

        Student student = new Student();//studentMapper.selectByPrimaryKey(5);
        student.setId(5);
        student.setUserName("阳阳2");

        studentMapper.updateByPrimaryKeySelective(student);

        sqlSession.commit();
    }


    @Test
    public void testPage() {
        // PageHelper.startPage(1, 3);
        PageHelper.offsetPage(3,3);
        StudentExample studentExample = new StudentExample();

        List<Student> studentList =  studentMapper.selectByExample(studentExample);

        for(Student student : studentList) {
            System.out.println(student);
        }

        PageInfo<Student> pageInfo = new PageInfo<>(studentList);

        System.out.println(pageInfo.getPageNum());
        System.out.println(pageInfo.getPages());


    }

}
