package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TodoListDao;
import model.dao.dto.TodoDTO;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DAOをインスタンス化
		TodoListDao todoListDao = new TodoListDao();
		// Todoの一覧を保持するListを初期化
		List<TodoDTO> todoList = new ArrayList<TodoDTO>();
		try {
			todoList = todoListDao.getTodoList();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		/* 
		 * リクエストスコープに
		 * 属性を追加する
		 * レスポンスを行うと破棄される
		 * JSPで使用できるようにする
		 * 第一引数がJSPで使用する属性名
		 * 第二引数がJSPに渡すオブジェクト
		*/
		request.setAttribute("todoList", todoList);
		
		// 上記処理完了後、どのファイルに遷移するか指定
		// 引数でファイル名を指定
		RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
		
		// forwardメソッドを使用して画面遷移する
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
