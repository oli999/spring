package test.service;

public interface WritingService {
	public void write();
	public void writeToFriend();
	public void writeToTeacher(String name);
	public String writeAndGet(int num);
}
