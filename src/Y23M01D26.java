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
	        	System.out.printf("%d  |  %s\n", article.id, article.title);
	        }
	         
	        
	        }
	        
	     
	      else {
	          System.out.println("존재하지 않는 명령어입니다.");
	        
	        }
	      
	      

	    }
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
	


