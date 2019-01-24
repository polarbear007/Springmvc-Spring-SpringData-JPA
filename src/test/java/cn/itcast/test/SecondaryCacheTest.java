package cn.itcast.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.annotations.QueryHints;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.dao.DepartmentDao;
import cn.itcast.entity.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SecondaryCacheTest {
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	// 使用springdata 提供的方法，查询所有部分信息，看一下能不能使用二级缓存
	// 不可以使用！！
	@Test
	public void test() {
		List<Department> list = departmentDao.findAll();
		List<Department> list2 = departmentDao.findAll();
	}
	
	// 我们自己不用 springdata 提供的方法，自己去创建 entityManager 来查询
	//  根据 id 来查询！！！
	//  可以使用二级缓存 
	@Test
	public void test2() {
		System.out.println("=============================");
		EntityManager manager1 = entityManagerFactory.createEntityManager();
		EntityTransaction transaction1 = manager1.getTransaction();
		transaction1.begin();
		Department dept1 = manager1.find(Department.class, 10);
		transaction1.commit();
		manager1.close();
		
		EntityManager manager2 = entityManagerFactory.createEntityManager();
		EntityTransaction transaction2 = manager2.getTransaction();
		transaction2.begin();
		Department dept2 = manager2.find(Department.class, 10);
		transaction2.commit();
		manager2.close();
		
		System.out.println(dept1 == dept2);
		System.out.println("=============================");
		
	}
	
	// 使用 springdata 提供的方法，根据 id 查询部分信息
	// 可以使用二级缓存 ！！！
	@Test
	public void test3() {
		Department dept1 = departmentDao.findOne(10);
		Department dept2 = departmentDao.findOne(10);
		System.out.println(dept1 == dept2);
	}
	
	// 不使用 springdata 提供的方法，自己创建 entityManager 来查询
	// 如果我们添加   setHint(QueryHints.CACHEABLE, true)  这个语句，就可以使用二级缓存 
	// 【注意】 原来springdata 提供的方法无法使用二级缓存就是因为没有添加上这个语句，这种复杂的查询是需要使用查询缓存的
	//        根据 id 进行查询的， 可以直接使用 二级 缓存
	@Test
	public void test4() {
		System.out.println("=============================");
		EntityManager manager1 = entityManagerFactory.createEntityManager();
		EntityTransaction transaction1 = manager1.getTransaction();
		transaction1.begin();
		List<Department> list1 = manager1.createQuery("from Department").setHint(QueryHints.CACHEABLE, true).getResultList();
		transaction1.commit();
		manager1.close();
		
		EntityManager manager2 = entityManagerFactory.createEntityManager();
		EntityTransaction transaction2 = manager2.getTransaction();
		transaction2.begin();
		List<Department> list2 = manager2.createQuery("from Department").setHint(QueryHints.CACHEABLE, true).getResultList();
		transaction2.commit();
		manager2.close();
		
		System.out.println("=============================");
	}
	
	// 当我们在  dao 接口的自定义方法上，添加了  @QueryHints()  注解以后
	// 这个 dao 接口又可以使用二级缓存中的查询缓存了
	@Test
	public void test5() {
		List<Department> list1 = departmentDao.findDepts();
		List<Department> list2 = departmentDao.findDepts();
	}
	
}
