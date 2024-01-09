package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "join.jsp";
		return viewPage;
	}

}
