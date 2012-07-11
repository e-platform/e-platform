<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery.ui.all/development-bundle/jquery-1.3.2.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery.ui.all/development-bundle/ui/ui.core.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery.ui.all/development-bundle/ui/ui.dialog.js" ></script>
<link href="<%=request.getContextPath()%>/jquery.ui.all/development-bundle/themes/base/ui.all.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	$(function() {
		var $text,okFunc,cancelFunc;
		$("body").prepend('<div id="dialog_msg" title="提示"></div>');
		$("body").prepend('<div id="dialog_confirm" title="提示"></div>');
		$.showDialog=function(type,text,okFunc,cancelFunc){
			if(type==1){
				$("#dialog_msg").dialog('open');
				$("#dialog_msg").text(text);
				$okFunc = okFunc;
			}else if(type==2){
				$("#dialog_confirm").dialog('open');
				$("#dialog_confirm").text(text);
				$okFunc = okFunc;
				$cancelFunc = cancelFunc;
			}
		}
		$("#dialog_msg").dialog({
			bgiframe: true,
			resizable: false,
			height:250,
			width:400,
			modal: true,
			autoOpen: false,
			overlay: {
				backgroundColor: '#000',
				opacity: 0.5
			},
			buttons: {
				'确定': function() {
					$(this).dialog('close');
					if($okFunc)
						window.eval($okFunc);
				}
			}
		});
		$("#dialog_confirm").dialog({
			bgiframe: true,
			resizable: false,
			height:250,
			width:400,
			modal: true,
			autoOpen: false,
			overlay: {
				backgroundColor: '#000',
				opacity: 0.5
			},
			buttons: {
				'取消': function() {
					$(this).dialog('close');
					if($cancelFunc)
						window.eval($cancelFunc);
				},
				'确定': function() {
					$(this).dialog('close');
					if($okFunc)
						window.eval($okFunc);
				}
			}
		});
	});
	</script>