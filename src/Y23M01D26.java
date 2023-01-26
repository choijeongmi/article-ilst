import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Y23M01D26 {
	public static void main(String[] args) {
	    System.out.println("==프로그램 시작==");

	    Scanner sc = new Scanner(System.in);

	    int lastId = 0; // 무한루프안에 넣지 않은 이유
	    
	    List<Article> articles = new ArrayList<>();
        
	    //무한루프
	    while (true) {
	      System.out.printf("명령어 )");
	      String cmd = sc.nextLine().trim(); // trim이란 입력문의 양끝 공백을 없애주는?

	      if(cmd.length()==0) {        
	        System.out.println("명령어를 입력하세요.");
	        continue;
	      }      

	      if(cmd.equals("끝")) {        
	        break;//브레이크=멈추다.
	      }
	      
	      if(cmd.equals("article write")) {
	        int id = lastId + 1;
	        lastId = id;
	        System.out.printf("제목 : ");
	        String title = sc.nextLine();
	        System.out.printf("내용 : ");
	        String body = sc.nextLine();

	        Article article = new Article(id, title, body);
	        articles.add(article);

	        System.out.printf("%d글이 생성되었습니다.\n",id);
	        
	      }

	      else if(cmd.equals("article list")) {
	        if (articles.size()==0){ // arraylist가 비어있는 경우
	        System.out.println("게시글이 없습니다.");
	        continue;// 컨티뉴를 만나면 위로 다시 올라가서 반복하는 경우를 없앤다. 바로 for문으로 이동.
	       
	        }
	        for(int i = articles.size() - 1; i >=0; i--) {
	        	Article article = articles.get(i);
	        	System.out.println("번호 | 제목");
	        	System.out.printf("%d   |  %s\n", article.id, article.title);
	        }
	         	        
	     }
	        
	      
//	      startsWith > ~ 로 시작한다면.  / split (쪼갠다, 분할)
	      else if(cmd.startsWith("article detail ")) {
	    	  String[] cmdBits = cmd.split(" "); // 공백을 기준으로 분할할래 라는 뜻 "공백"
//	    	  =>명령문이 3개의 분할이기 때문에 [] 배열로 묶어준다.
	    	  int id = Integer.parseInt(cmdBits[2]);
	    	  
	    	  
	    	  Article foundArticle = null;
			for (int i = 0; i < articles.size(); i++) {
	    		  Article article = articles.get(i);
//	    		=> 0부터 size 전까지 탐색하겠다 라는 뜻. i = 0  
	    		  if (article.id == id) {
//	    			  found = true; > found 가 참일 경우 브레이크. 로 넣어줄수도 있음
	    			  foundArticle = article;
	    			  break; //  가장 가까운 반복문을 탈출하는 거. 탐색 중 정답을 찾았을때 탐색을 중지시키기위해
	    		  }
	    	  }
//	    	위의  for문에서 탐색을 마친 후 정답을 찾으면 break를 통해 for문을 빠져나와 아래의  if문으로 이동.	
//			  
	    	  if (foundArticle == null) { // 찾은 게시물(foundArticle)이 없을때
	    		  System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
	    		  continue;
	    	  }    
	    	    // 그 외의 값이면 아래가 출력 >>  외의값은 found  값이 트루일 경우 if가 아닌 else로 이동.
	    		  System.out.printf("%d번 게시물은 존재합니다.\n", id);
	    		  System.out.printf("번호 : %d\n", foundArticle.id);
	    		  System.out.printf("날짜 :2022-01-26\n" );
	    		  System.out.printf("제목 : %s\n", foundArticle.title);
	    		  System.out.printf("내용 : %d\n", foundArticle.body);
		        
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ		        
	   
		        }
	      else if(cmd.startsWith("article delete ")) {
	    	  String[] cmdBits = cmd.split(" "); 
    	  
	    	  int id = Integer.parseInt(cmdBits[2]);
	    	  Article foundArticle = null;
	    	  for (int i = 0; i < articles.size(); i++) {
	    		  Article article = articles.get(i);
    		 
	    		  if (article.id == id) {
	    			  foundArticle = article;
	    			  break;
	    		  }
	    	  }
	    	  if (foundArticle == null) {
	    		  System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
	    		  continue;
	    	  }
	    	  articles.remove(id - 1);
	    	  
	    	  System.out.printf("%d번 게시물이 삭제 되었습니다.\n", id);

	    	  
	    	  
	    	  
	      }
	      
//		     코드정리 -> 리팩토링이라고 한다.
		  
	      
	      

	    }
	    sc.close();
	    System.out.println("==프로그램 종료==");
	  }
	}

	class Article {
	  int id;
	  String title;
	  String body;
	 public Article(int id, String title, String body) {
	    this.id = id;
	    this.title = title;
	    this.body = body;

	    
	  }
	}
	


