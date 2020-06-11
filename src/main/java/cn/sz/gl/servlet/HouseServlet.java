package cn.sz.gl.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sz.gl.dao.IHouseDAO;
import cn.sz.gl.dao.IHouseStyleDAO;
import cn.sz.gl.dao.IRegionDAO;
import cn.sz.gl.dao.impl.HouseDAOImpl;
import cn.sz.gl.dao.impl.HouseStyleDAOImpl;
import cn.sz.gl.dao.impl.RegionDAOImpl;
import cn.sz.gl.pojo.House;
import cn.sz.gl.pojo.HouseStyle;
import cn.sz.gl.pojo.Region;

public class HouseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String status = request.getParameter("status");
		if(status==null||status.equals("")) {
			status = "findhouse";
		}
		
		if(status.equals("findhouse")) {
			this.findhousesplit(request, response);
		}
		
		
	}
	
	public void findhousesplit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		IHouseDAO housedao = new HouseDAOImpl();
		int cp = 1;
		int ps = 3;
		
		String ccp = request.getParameter("cp");
		if(ccp!=null&&!ccp.equals("")) {
			cp = Integer.valueOf(ccp);
		}
		
		String pss = request.getParameter("ps");
		if(pss!=null&&!pss.equals("")) {
			ps = Integer.valueOf(pss);
		}
		
		//request.setCharacterEncoding("utf-8");
		
		
		String kw = request.getParameter("kw");
		String price = request.getParameter("price");
		String code = request.getParameter("code");
		String styleid = request.getParameter("styleid");
		String area = request.getParameter("area");
		
		
		
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", (cp-1)*ps);
		map.put("ps", ps);
		if(kw!=null&&!kw.equals("")) {
			kw = new String(kw.getBytes("iso-8859-1"),"utf-8");
			map.put("kw", kw);
		}
		if(price!=null&&!price.equals("")&&price.indexOf("-")!=-1) {
			String [] arr_price = price.split("-");
			map.put("loprice", arr_price[0]);
			map.put("hiprice", arr_price[1]);
		}
		
		if(code!=null&&!code.equals("")) {
			map.put("code", code);
		}
		if(styleid!=null&&!styleid.equals("")) {
			map.put("styleid", styleid);
		}
		
		if(area!=null&&!area.equals("")&&area.indexOf("-")!=-1) {
			String [] arr_area = area.split("-");
			map.put("loArea", arr_area[0]);
			map.put("hiArea", arr_area[1]);
		}
		
		
		List<House> houselist = housedao.findHouse(map);
		int count = housedao.getCount(map);//满足条件的数据的总行数
		int totalpage = (count-1)/ps+1;//统计总页码数
		
		
		//查询所有的房屋类型
		IHouseStyleDAO styledao = new HouseStyleDAOImpl();
		List<HouseStyle> stylelist = styledao.findall();
		//查询所有的房屋位置
		IRegionDAO regiondao = new RegionDAOImpl();
		List<Region> regionlist = regiondao.findRegion();
		//联表，查询房屋所在的街道名字
		//联表，查询房屋所属的类型名字
		
		//接下来，就可以传递servlet中查询的数据到页面，然后跳转到页面，并在页面上动态显示查询的结果
		request.setAttribute("houselist", houselist);
		request.setAttribute("count", count);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("cp", cp);
		request.setAttribute("ps", ps);
		request.setAttribute("map", map);
		request.setAttribute("stylelist", stylelist);
		request.setAttribute("regionlist", regionlist);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
	}

}
