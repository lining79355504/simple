/*
  解决微信二次分享问题，使用时需要引入微信JS-SDK，以及本js文件：
  <script src="https://res.wx.qq.com/open/js/jweixin-1.4.0.js"></script>
  <script src="https://movie-cdn.o2o.cmbchina.com/web/event/wx.js"></script>
  请在页面中声明 shareData 或者 wx_shareData 否则二次分享内容会实用默认配置
*/

var wx_authParams = {
    appId: 'wx1a08c54f2fc8b293',
    signature: '',
    nonceStr: '',
    timestamp: '',
};

$(function() {
    $.ajax({
        url: '/ActivityCenterMarketing/weChat/multiShares.json',
        type: 'POST',
        dataType: 'json',
        data: {
            currentPageUrl: location.href.split('#')[0]
        },
    })
        .done(function(res) {
            if (res && +res.respCode === 1000 && res.respData) {
                wx_authParams.signature = res.respData.signature;
                wx_authParams.nonceStr = res.respData.nonceStr;
                wx_authParams.timestamp = res.respData.timestamp;
                wxShareConfig();
            }
        })
        .fail(function(res) {
            console.log("error: ", res);
        });
});

function wxShareConfig () {
    var wx_userAgent = {
        iOS: !!ua.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/),
        android: ua.indexOf('Android') > -1 || ua.indexOf('Linux') > -1,
    };
    var jsApiList = [];
    if (wx_userAgent.iOS) {
        jsApiList = ['updateAppMessageShareData', 'updateTimelineShareData', 'onMenuShareWeibo'];
    } else if (wx_userAgent.android) {
        // 微信Android6.7.3版本还不支持新接口，官方文档描述有误
        jsApiList = ['onMenuShareAppMessage', 'onMenuShareTimeline', 'onMenuShareWeibo']
    }
    wx.config({
        debug: false,
        appId: wx_authParams.appId,
        timestamp: wx_authParams.timestamp,
        nonceStr: wx_authParams.nonceStr,
        signature: wx_authParams.signature,
        jsApiList: jsApiList
    });
    wx.ready(function(){
        var wx_shareConfig = {
            title: '掌上生活 特惠看电影',
            desc: '新户9元起 工作日9积分 看大片',
            url: location.href.split('#')[0],
            img: 'https://movie-cdn.o2o.cmbchina.com/web/event/wechatLanding/images/main.jpg',
        };
        if (window.shareData) {
            wx_shareConfig = window.shareData
        }
        if (window.wx_shareData) {
            wx_shareConfig = window.wx_shareData
        }
        var msg = {title: wx_shareConfig.title, desc: wx_shareConfig.desc, link: wx_shareConfig.url, imgUrl: wx_shareConfig.img};
        if (wx_userAgent.iOS) {
            wx.updateAppMessageShareData(msg);
            wx.updateTimelineShareData(msg);
            wx.onMenuShareWeibo(msg);
        } else if (wx_userAgent.android) {
            wx.onMenuShareAppMessage(msg);
            wx.onMenuShareTimeline(msg);
            wx.onMenuShareWeibo(msg);
        }

    });
}