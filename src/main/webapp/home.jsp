<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page language="java" pageEncoding="utf-8"%>
<%@page import="com.xuanjia.merry.model.Wedding"%>
<html class="no-js">
<!--<![endif]-->

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta content="telephone=no" name="format-detection" />
<%
    Wedding wedding = (Wedding) request.getAttribute("wedding");
			Calendar calendar = wedding.getStartTime();
%>
<title><%=wedding.getTitle()%></title>
<link rel="stylesheet" type="text/css" href="css/normalize.css">
<link rel="stylesheet" type="text/css" href="css/jquery.fullPage.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/modernizr-2.6.2.min.js"></script>
<script src="js/jweixin-1.0.0.js"></script>

<script type="text/javascript">
wx.ready(function () {   //ready函数用于调用API，如果你的网页在加载后就需要自定义分享和回调功能，需要在此调用分享函数。//如果是微信游戏结束后，需要点击按钮触发得到分值后分享，这里就不需要调用API了，可以在按钮上绑定事件直接调用。因此，微信游戏由于大多需要用户先触发获取分值，此处请不要填写如下所示的分享API
	wx.onMenuShareTimeline({  //例如分享到朋友圈的API  
	   title: '', // 分享标题
	   link: '', // 分享链接
	   imgUrl: '', // 分享图标
	   success: function () {
	       // 用户确认分享后执行的回调函数
	   },
	   cancel: function () {
	       // 用户取消分享后执行的回调函数
	   }
	});
	});
	wx.error(function (res) {
	 alert(res.errMsg);  //打印错误消息。及把 debug:false,设置为debug:ture就可以直接在网页上看到弹出的错误提示
	});
</script>
</head>

<body>
	<div style="display:none"> <img src="http://evilsylvana-photo.oss-cn-shenzhen.aliyuncs.com/7.jpg" /> </div>
	<div class="loading">
		<div class="spinner">
			<div class="bounce1"></div>
			<div class="bounce2"></div>
			<div class="bounce3"></div>
		</div>
	</div>

	<div class="container">
		<div id="fullpage">
			<div class="music-control play">
				<p class="music-state">开启</p>
				<span class="music-icon"></span>
			</div>
			<div class="swipe-tip">
				<p></p>
			</div>

			<!-- 首页 -->
			<div class="section" id="section1"></div>


			<div class="section" id="section2">
				<div class="slide" id="slide1"></div>
				<div class="slide" id="slide2"></div>
				<div class="slide" id="slide3"></div>
				<div class="slide" id="slide4"></div>
				<div class="slide" id="slide5"></div>
			</div>

			<div class="section" id="section3">
				<div id="ta_0map">
					<div class="tit slideInLeft">
						<table cellspacing="0" cellpadding="0" border="0" width="80%">
							<tbody>
								<tr>
									<td width="50%" align="center" class="name"><img
										src="images/tit1.png"> <span> <%=wedding.getBridegroom()%></span>
										<cite> <%=wedding.getBride()%></cite></td>
									<td width="50%" class="date">
										<table cellspacing="0" cellpadding="0" border="0" width="70%">
											<tbody>
												<tr>
													<td style="font-size: 24px" align="left" height="30"
														width="50"><%=calendar.get(Calendar.YEAR)%></td>
													<td rowspan="2" style="font-size: 50px" align="left"><%=calendar.get(Calendar.DAY_OF_MONTH)%>日</td>
												</tr>
												<tr>
													<td style="font-size: 24px" align="left" height="30"><%=calendar.get(Calendar.MONTH) + 1%>月</td>
												</tr>
												<tr>
													<td colspan="2" style="font-size: 24px" align="left"><%=String.format("%02d:%02d",
					calendar.get(Calendar.HOUR_OF_DAY),
					calendar.get(Calendar.MINUTE))%>PM</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div id="maparea">
						<a href="<%=wedding.getLocationBaiDuUrl()%>"> <img
							src="<%=wedding.getLocalcationStaticBaiduUrl()%>">
						</a>
						<p style="overflow: hidden;"><%=wedding.getLocation()%></p>
					</div>
				</div>
				<div class="hinfo">
					<p class="guide">
						<a href="<%=wedding.getLocationBaiDuUrl()%>" title="点击一键导航">点击一键导航</a>
					</p>
					<p class="phone">
						<a href="tel:<%=wedding.getBridePhone()%>">新娘电话：<%=wedding.getBridePhone()%></a>
					</p>
					<p class="phone">
						<a href="tel:<%=wedding.getBridePhone()%>">新郎电话：<%=wedding.getBridegroomPhone()%></a>
					</p>
				</div>
			</div>
			<audio src="music/love.mp3" id="bgm"></audio>
		</div>
	</div>
	<script src="js/jquery-1.10.2.min.js"></script>
	<script src="js/jquery.easings.min.js"></script>
	<script src="js/jquery.fullPage.min.js"></script>
	<script src="js/common.js"></script>
</body>

</html>
