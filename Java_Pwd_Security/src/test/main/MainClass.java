package test.main;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClass {
	public static void main(String[] args) {
		//비밀 번호라고 가정
		String pwd="1234";
		//비밀번호 인코더 객체 생성 
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		//비밀번호를 인코딩하기
		String hash1=encoder.encode(pwd);
		String hash2=encoder.encode(pwd);
		String hash3=encoder.encode(pwd);
		
		//인코딩된 문자열 출력해 보기
		System.out.println(hash1);
		System.out.println(hash2);
		System.out.println(hash3);
	}
}








