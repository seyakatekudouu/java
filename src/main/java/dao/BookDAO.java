package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Book;



public class BookDAO {

	// DBへのConnectionを取得（本番環境/テスト環境 切り替え用）
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	
	// 学生のデータを全件取得する
		public static List<Book> selectAllBook() {
			
			// 返却用変数
			List<Book> result = new ArrayList<>();

			String sql = "SELECT * FROM book";
			
			try (
					Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				try (ResultSet rs = pstmt.executeQuery()){
					while(rs.next()) {
						String ID = rs.getString("ID");
						String ISBN = rs.getString("ISBN");
						String bookname = rs.getString("bookname");
						String writer = rs.getString("writer");
						String shupansha = rs.getString("shupansha");

						Book employee = new Book(ID,ISBN,bookname,writer,shupansha);
						
						result.add(employee);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}

			// Listを返却する。0件の場合は空のListが返却される。
			return result;
		}
		
		//引数の社員番号を元にデータを1件 DELETE するメソッド
		public static void deleteBook(String ISBN) {
			String sql = "DELETE FROM book WHERE ISBN = ?";
			int result = 0;

			try (
					Connection con = getConnection();	// DB接続
					PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
					){

				pstmt.setString(1,ISBN);

				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} finally {
				System.out.println(result + "件更新しました。");
			}
		}
	
	// 引数の Student インスタンスを元にデータを1件INSERTするメソッド
		public static int registerBook(Book book) {

		String sql = "INSERT INTO book VALUES( ?, ?, ?, ?, ?)";
			int result = 0;
			
			try (
					Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				pstmt.setString(1, book.getID());
				pstmt.setString(2, book.getISBN());
				pstmt.setString(3, book.getBookname());
				pstmt.setString(4, book.getWriter());
				pstmt.setString(5, book.getShupansha());

				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} finally {
				System.out.println(result + "件更新しました。");
			}
			return result;
		}

		
		// LIKEを使ったキーワード検索(部分一致)
		public static List<Book> searchBookByISBN(String keyword){
			
			// 実行するSQL
			String sql = "SELECT * FROM book WHERE ISBN LIKE ?";
			// ダメな例 String sql = "SELECT * FROM employee WHERE name LIKE %?%";
			// なぜなら値を埋め込むとSELECT * FROM employee WHERE name LIKE %'keyword'%となるから。
			
			// 返却用のListインスタンス
			List<Book> result = new ArrayList<>();
					
			try (
					Connection con = getConnection();	// DB接続
					PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
					){
				
				// %や_はここで文字列結合する。そうすると'%keyword%'となる。
				pstmt.setString(1, "%" + keyword + "%");
				
				// SQL実行！
				// ResultSetもcloseする必要があるのでtry-with-resources文を使う
				try (ResultSet rs = pstmt.executeQuery()){
					
					// next()がfalseを返すまでループ
					while(rs.next()) {

						// n行目のデータを取得
						String ID = rs.getString("ID");
						String ISBN = rs.getString("ISBN");
						String bookname = rs.getString("bookname");
						String writer = rs.getString("writer");
						String shupansha = rs.getString("shupansha");

						// n件目のインスタンスを作成
						Book book = new Book(ID,ISBN,bookname,writer,shupansha);
						
						// インスタンスをListに追加
						result.add(book);
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}

			// Listを返却する。0件の場合は空のListが返却される。
			return result;
		}
		}

