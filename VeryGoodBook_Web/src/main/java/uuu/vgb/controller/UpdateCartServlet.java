package uuu.vgb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uuu.vgb.entity.CartItem;
import uuu.vgb.entity.ShoppingCart;

/**
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet("/member/update_cart.do")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errorsList = new ArrayList<>();
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
		if(cart!=null) {
			for(CartItem item:cart.getCartItemsSet()) {
				//1.取得form data
				String quantity = request.getParameter("quantity" + item.hashCode()); 
				String delete = request.getParameter("delete" + item.hashCode());
				
				if(delete==null) { //修改數量
					if(quantity!=null && quantity.matches("\\d+")) {
						int qty = Integer.parseInt(quantity);						
						cart.update(item, qty);
					}else {
						errorsList.add( item.getProductId() + "-" + item.getColorName() + "-" + item.getSizeName()
								+ "數量不正確: " + quantity);
					}					
				}else{    //刪除明細
					cart.remove(item);
				}
			}
		}
		
		//3.redirect 回/member/cart.jsp
		String submit = request.getParameter("submit");
		if("checkout".equals(submit)) {
			response.sendRedirect("check_out.jsp");
		}else {
			response.sendRedirect(request.getContextPath() + "/member/cart.jsp");
		}
	}

}
