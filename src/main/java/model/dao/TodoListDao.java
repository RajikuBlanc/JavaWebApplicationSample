package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DBConnection;
import model.dao.dto.TodoDTO;

public class TodoListDao {
	/*
	 * Todoの一覧を取得
	 * @return todoの一覧
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */ 
	
	public List<TodoDTO> getTodoList() throws SQLException, ClassNotFoundException{
		//  Listの初期化
		List<TodoDTO> todoList = new ArrayList<TodoDTO>();
		// SQL
		String sql = "SELECT id, todo, timeLimit FROM todo";
		
		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			// ResultSetにSQLの実行結果を格納
				ResultSet res = pstmt.executeQuery();
				
				while (res.next()) {
						int id = res.getInt("id");
						String todo = res.getString("todo");
						Date timeLimit = res.getDate("timeLimit");
						
						// 取得できたレコードごとにTodoDTOのインスタンスを生成する
						todoList.add(new TodoDTO(id,todo,timeLimit));
				}
				
		} catch (Exception e) {
			System.out.println(e);
		}
		return todoList; 
	};
}
