package kr.co.ezenac.main;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.ezenac.beans.JdbcBean;
import kr.co.ezenac.config.BeanConfigClass;
import kr.co.ezenac.db.JdbcDAO;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		JdbcDAO dao = ctx.getBean(JdbcDAO.class);

		JdbcBean bean1 = ctx.getBean(JdbcBean.class);
		bean1.setInt_data(1);
		bean1.setStr_data("문자열1");
		JdbcBean bean2 = ctx.getBean(JdbcBean.class);
		bean2.setInt_data(2);
		bean2.setStr_data("문자열2");

//		dao.insert_data(bean1);
//		dao.insert_data(bean2);
//		System.out.println("저장 완료");
//		dao.select_data()
//				.forEach(s -> System.out.printf("int_data: %d str_data: %s\n", s.getInt_data(), s.getStr_data()));
		JdbcBean bean4 = ctx.getBean(JdbcBean.class);
		bean4.setInt_data(bean2.getInt_data());
		bean4.setStr_data("문자열4");
		dao.update_data(bean4);

		// delete
		dao.delete_data(bean2.getInt_data());
		dao.select_data()
				.forEach(s -> System.out.printf("int_data: %d str_data: %s\n", s.getInt_data(), s.getStr_data()));
//		List<JdbcBean> list = dao.select_data();
//		Iterator<JdbcBean> iterator = list.iterator();
//		System.out.println("iterator문");
//		while (iterator.hasNext()) {
		// JdbcBean bean3 = (JdbcBean) iterator.next();
//			System.out.printf("int_data: %d str_data: %s\n", bean3.getInt_data(), bean3.getStr_data());
//		}
//		System.out.println("forEach문");
//		for (JdbcBean jdbcBean : list) {
//			System.out.printf("int_data: %d str_data: %s\n", jdbcBean.getInt_data(), jdbcBean.getStr_data());
//		}
//		dao.delete_data(bean4.getInt_data());
//		System.out.println("삭제 성공");
		ctx.close();
	}

}
