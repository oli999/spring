package test.service;

import org.springframework.stereotype.Component;

// component scan 을 했을때 bean 으로 만들기 위한 어노테이션 
@Component
public class WritingServiceImpl implements WritingService{

	@Override
	public void write() {
		System.out.println("글쓰기 작업중...");
		try {
			Thread.sleep(5000);
		}catch(Exception e) {};
	}

	@Override
	public void writeToFriend() {
		System.out.println("친구에게 글쓰기 작업중...");
		try {
			Thread.sleep(5000);
		}catch(Exception e) {};
	}

	@Override
	public void writeToTeacher(String name) {
		System.out.println(name+"선생님 글쓰기 작업중...");
		try {
			Thread.sleep(5000);
		}catch(Exception e) {};
	}

	@Override
	public String writeAndGet(int num) {
		System.out.println("글쓰기 작업하고 문자열을 돌려줍니다.");
		return "Acorn";
	}

}









