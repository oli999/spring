package test.service;

public class CafeServiceImpl implements CafeService{

	@Override
	public void insert() {
		System.out.println("카페 글을 추가 합니다.");
	}

	@Override
	public void select() {
		System.out.println("카페 글 목록을 불러옵니다.");
	}

}
