<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	System.out.println("basepath:"+basepath);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0030)http://localhost:8080/House-2/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<base href="<%=basepath %>" />
<TITLE>自如租房 - 首页</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514">

<script type="text/javascript">
	function gopage(mypage){
		var totalpage = parseInt(document.getElementById("totalpage").value);
		if(parseInt(mypage)<1){
			alert("已经是第一页了");
		}else if(parseInt(mypage)>totalpage){
			alert("已经是最后一页了");
		}else{
			splitform.cp.value = mypage;
			splitform.submit();
		}
	}
	
	
	function doSearch(){
		splitform.cp.value = 1;
		splitform.submit();
	}

</script>


</HEAD>
<BODY>
	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.jpg">
		</DIV>
	</DIV>
	<form name="splitform" action="hs" method="post" >
		<input type="hidden" value="findhouse" name="status" id="status" />
		<input type="hidden" value="${totalpage }" name="totalpage" id="totalpage" >
		<input type="hidden" value="" name="cp" id="cp" />
	<DIV id=navbar class=wrap>
		<DL class="search clearfix">
				<DT>
					<UL>
						<LI class="bold">房屋信息</LI>
						<LI>
							标题：<INPUT class="text" type="text" value="${map.kw }" name="kw"> 
							<LABEL class="ui-blue">
								<INPUT onclick="doSearch()" value="搜索房屋 " type="button" name="search">
							</LABEL>
						</LI>
					</UL>
				</DT>
				<DD>
					<UL>
						<LI class="first">价格</LI>
						<LI>
							<SELECT name="price">
								<OPTION selected value="">不限</OPTION>
								<OPTION ${map.hiprice=='1000'?"selected":"" } value="0-1000">1000元以下</OPTION>
								<OPTION ${map.hiprice=='1500'?"selected":"" } value="1000-1500">1000元—1500元</OPTION>
								<OPTION ${map.hiprice=='2000'?"selected":"" } value="1500-2000">1500元—2000元</OPTION>
								<OPTION ${map.loprice=='2000'?"selected":"" } value="2000-1000000">2000元以上</OPTION>
							</SELECT>
						</LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<LI class="first">房屋位置</LI>
						<LI><SELECT id="code" name="code">
								<OPTION selected value="">不限</OPTION>
								<c:forEach items="${regionlist }" var="rl">
								<OPTION ${map.code==rl.code?"selected":"" } value="${rl.code }">${rl.regionNameCn }</OPTION>
								</c:forEach>
								
						</SELECT></LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<LI class="first">房型</LI>
						<LI><SELECT name="styleid">
								<OPTION selected value="">不限</OPTION>
								<c:forEach items="${stylelist }" var="sl" >
								<OPTION ${map.styleid==sl.styleid?"selected":"" } value="${sl.styleid }">${sl.styleName }</OPTION>
								</c:forEach>
						</SELECT></LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<LI class="first">面积</LI>
						<LI><SELECT name="area">
								<OPTION selected value="">不限</OPTION>
								<OPTION ${map.hiArea=='40'?"selected":"" } value="0-40">40以下</OPTION>
								<OPTION ${map.hiArea=='500'?"selected":"" } value="40-500">40-500</OPTION>
								<OPTION ${map.loArea=='500'?"selected":"" } value="500-1000000">500以上</OPTION>
						</SELECT></LI>
					</UL>
				</DD>
			
		</DL>
	</DIV>
	<DIV class="main wrap">
		<TABLE class=house-list>
			<TBODY>
			
				<c:forEach items="${houselist }" var="hl" varStatus="hlstatus" >
				<TR class="${hlstatus.count%2==1?'odd':'' }">
					<TD class="house-thumb">
						<span>
							<A href="details.htm" target="_blank">
								<img src="${hl.picpath }" width="100" height="75" alt="">
							</a>
						</span>
					</TD>
					<TD>
						<DL>
							<DT>
								<A href="details.htm" target="_blank">${hl.title }</A>
							</DT>
							<DD>
								${hl.region.region.regionNameCn }${hl.region.regionNameCn },${hl.houseArea }平米<BR>联系方式：${hl.phone }
							</DD>
						</DL>
					</TD>
					<TD class=house-type>${hl.houseStyle.styleName }</TD>
					<TD class=house-price><SPAN>${hl.price }</SPAN>元/月</TD>
				</TR>
				</c:forEach>
				
				
				
				
				<TR><td colspan="4" >
					<c:if test="${houselist==null }">无租房信息</c:if>
				</td>
				</TR>
			</TBODY>
		</TABLE>
		<DIV class="pager">
			
			<UL>
				<LI class=current><A href="javascript:void(0);" onclick="gopage('1');">首页</A></LI>
				<LI><A href="javascript:void(0);" onclick="gopage('${cp-1}');">上一页</A></LI>
				<LI><A href="javascript:void(0);" onclick="gopage('${cp+1}');">下一页</A></LI>
				<LI><A href="javascript:void(0);" onclick="gopage('${totalpage}');">末页</A></LI>
			</UL>
			<SPAN class=total>${cp }/${totalpage }页</SPAN>
			
		</DIV>
	</DIV>
	</form>
	<DIV id=footer class=wrap>
		<DL>
			<DT>自如租房 © 2010 北京自如 京ICP证1000001号</DT>
			<DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
		</DL>
	</DIV>
</BODY>
</HTML>
