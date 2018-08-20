package com.gura.spring03.cafe.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.cafe.dao.CafeCommentDao;
import com.gura.spring03.cafe.dao.CafeDao;
import com.gura.spring03.cafe.dto.CafeCommentDto;
import com.gura.spring03.cafe.dto.CafeDto;
import com.gura.spring03.exception.ForbiddenException;

@Service
public class CafeServiceImpl implements CafeService{
	@Autowired
	private CafeDao cafeDao;
	@Autowired
	private CafeCommentDao cafeCommentDao;
	
	//한 페이지에 나타낼 로우의 갯수
	private static final int PAGE_ROW_COUNT=5;
	//하단 디스플레이 페이지 갯수
	private static final int PAGE_DISPLAY_COUNT=3;	
	
	@Override
	public void getList(HttpServletRequest request) {
		/*
		 *  request 에 검색 keyword 가 전달 될수도 있고 안될수도 있다.
		 *  1. 전달 안되는 경우 : home 에서 목록보기를 누른경우
		 *  2. 전달 되는 경우 : list.do 에서 검색어를 입력후 form 전송한
		 *     경우. 
		 *  3. 전달 되는 경우 : 이미 검색을 한 상태에서 페이지 링크를 
		 *     누른경우
		 */
		//검색과 관련된 파라미터를 읽어와 본다.
		String keyword=request.getParameter("keyword");
		String condition=request.getParameter("condition");		
		
		//CafeDto 객체를 생성해서 
		CafeDto dto=new CafeDto();
		if(keyword != null) {//검색어가 전달된 경우 
			if(condition.equals("titlecontent")) {//제목+내용 검색
				dto.setTitle(keyword);
				dto.setContent(keyword);
			}else if(condition.equals("title")) {//제목 검색
				dto.setTitle(keyword);
			}else if(condition.equals("writer")) {//작성자 검색
				dto.setWriter(keyword);
			}
			//list.jsp 에서 필요한 내용 담기
			request.setAttribute("condition", condition);
			request.setAttribute("keyword", keyword);
		}
		
		//보여줄 페이지의 번호
		int pageNum=1;
		//보여줄 페이지의 번호가 파라미터로 전달되는지 읽어온다.
		String strPageNum=request.getParameter("pageNum");
		if(strPageNum != null){//페이지 번호가 파라미터로 넘어온다면
			//페이지 번호를 설정한다.
			pageNum=Integer.parseInt(strPageNum);
		}
		//보여줄 페이지 데이터의 시작 ResultSet row 번호
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		//보여줄 페이지 데이터의 끝 ResultSet row 번호
		int endRowNum=pageNum*PAGE_ROW_COUNT;
		
		//전체 row 의 갯수를 읽어온다.
		int totalRow=cafeDao.getCount(dto);
		//전체 페이지의 갯수 구하기
		int totalPageCount=
				(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		//시작 페이지 번호
		int startPageNum=
			1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		//끝 페이지 번호
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		//끝 페이지 번호가 잘못된 값이라면 
		if(totalPageCount < endPageNum){
			endPageNum=totalPageCount; //보정해준다. 
		}
		
		// 위에서 만든 CafeDto 에 추가 정보를 담는다. 
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		
		//1. FileDto 객체를 전달해서 파일 목록을 불러온다 
		List<CafeDto> list=cafeDao.getList(dto);
		
		//2. request 에 담고
		request.setAttribute("list", list);
		// 페이징 처리에 관련된 값도 request 에 담기 
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("totalPageCount", totalPageCount);
		// 전체 row 의 갯수도 전달하기
		request.setAttribute("totalRow", totalRow);		
	}

	@Override
	public void insert(HttpServletRequest request) {
		//작성자
		String writer=(String)request.getSession().getAttribute("id");
		//제목
		String title=request.getParameter("title");
		//내용
		String content=request.getParameter("content");
		
		//CafeDto 에 담기
		CafeDto dto=new CafeDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		//DB 에 저장
		cafeDao.insert(dto);
		
	}

	@Override
	public void detail(HttpServletRequest request) {
		//1. 파라미터로 전달되는 글번호 읽어오기
		int num=Integer.parseInt(request.getParameter("num"));
		//검색과 관련된 파라미터를 읽어와 본다.
		String keyword=request.getParameter("keyword");
		String condition=request.getParameter("condition");		
		
		//CafeDto 객체를 생성해서 
		CafeDto dto=new CafeDto();
		if(keyword != null) {//검색어가 전달된 경우 
			if(condition.equals("titlecontent")) {//제목+내용 검색
				dto.setTitle(keyword);
				dto.setContent(keyword);
			}else if(condition.equals("title")) {//제목 검색
				dto.setTitle(keyword);
			}else if(condition.equals("writer")) {//작성자 검색
				dto.setWriter(keyword);
			}
			//list.jsp 에서 필요한 내용 담기
			request.setAttribute("condition", condition);
			request.setAttribute("keyword", keyword);
		}		
		//글번호도 dto 에 담는다.
		dto.setNum(num);
		
		//2. CafeDao 를 이용해서 글정보를 읽어와서
		CafeDto resultDto=cafeDao.getData(dto);
		// 글 조회수 올리기
		cafeDao.addViewCount(num);
	
		//3. request 에 담고
		request.setAttribute("dto", resultDto);
		//로그인 여부 확인해서  request 에 담기 
		String id=(String)request.getSession().getAttribute("id");
		boolean isLogin=false;
		if(id!=null) {
			isLogin=true;
		}
	
		// 로그인 여부 
		request.setAttribute("isLogin", isLogin);
		// 댓글 목록
		List<CafeCommentDto> commentList=
				cafeCommentDao.getList(num);
		request.setAttribute("commentList", commentList);		
	}

	@Override
	public void commentInsert(CafeCommentDto dto) {
		
		//저장할 댓글의 번호를 미리 얻어낸다.
		int seq=cafeCommentDao.getSequence();
		//댓글을 DB 에 저장
		dto.setNum(seq);
		//댓글의 그룹 번호를 읽어온다. ( 0 or 다른 숫자가 들어있다 )
		int comment_group=dto.getComment_group();
		if(comment_group==0) {//원글의 댓글인 경우
			dto.setComment_group(seq);
		}
		//새 댓글을 저장한다. 
		cafeCommentDao.insert(dto);		
	}

	@Override
	public void delete(HttpServletRequest request) {
		
		//1. 파라미터로 전달되는 글번호
		int num=Integer.parseInt(request.getParameter("num"));
		
		/*
		 *  로그인된 아이디와 삭제할 글의 작성자와 다르면
		 *  ForbiddenException 발생 시키기
		 */
		String id=(String)request.getSession().getAttribute("id");
		//글번호를 이용해서 
		CafeDto dto=new CafeDto();
		dto.setNum(num);
		//해당글의 작성자를 읽어와서 
		String writer=cafeDao.getData(dto).getWriter();
		if(!id.equals(writer)) {
			throw new ForbiddenException();
		}
		
		//2. 삭제하기 
		cafeDao.delete(num);
	}

	@Override
	public void update(HttpServletRequest request) {
		//수정할 글정보 얻어오기 
		int num=Integer.parseInt(request.getParameter("num"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		//CafeDto 에 담기
		CafeDto dto=new CafeDto();
		dto.setNum(num);
		dto.setTitle(title);
		dto.setContent(content);
		//CafeDao 를 이용해서 수정 반영
		cafeDao.update(dto);		
	}
	
}
















