<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/mytld" prefix="my" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CustomerTag demo</title>
    </head>
    <body style="padding: 20px">
        <h1><my:hello /></h1>
        <h1><my:hellouser name="John" /></h1>
        <h1><my:stock symbol="2330.TW" qty="2000" /></h1>
        <h1><my:stock symbol="USDTWD=x" /></h1>
        <h1><my:stock symbol="TWDUSD=x" qty="10000" /></h1>
        <h1>
            <my:lotto amount="6">
                樂透彩開獎:
            </my:lotto>
        </h1>
        <h1>
            <my:loop count="10">
                中秋節
            </my:loop>
        </h1>
        <hr>
        <h1>
            <my:search key="共軍" key2="國軍">
                空軍司令部今天下午發布共機挑釁動態，大批共機再度侵入我西南空域防空識别區，其中12架甚至先後跨越西北空域的台海中線，距我新竹12浬領空僅25浬、海岸線37浬、約68.5公里。國防部證實，不止共機跨越台海中線，共軍艦艇也進入海峽中線以西活動，國軍包括飛彈、偵巡艦艇、空軍聯隊均提升戰備，在基隆擔任緊急待命任務的成功艦也奉令出航因應。

                國防部今天仍進行漢光36號演習兵棋推演，國防部長嚴德發與參謀總長黃曙光因海峽共軍機艦挑釁狀況，均離席進入衡山指揮所因應。這是九六台海危機後，共軍在當面海峽中線所採取最激烈的挑釁作為。

                共軍殲16、殲11與殲10計12架，上午7點起至10時30分，以特定區域繞行的姿態，陸續穿越西北海峽中線進入中線以西空域，越過中線時間有長有短，另有共軍艦艇同時也穿越中線。轟6和殲16則在西南空域活動。

                我方研判，此舉是共軍有計畫性、針對性、實戰化戰訓的挑釁作為，與以往不同。我方研判此舉屬於蓄意騷擾，但共軍地面部隊並無異常集結，我方雖提升「部分」戰備，包括飛彈、空軍聯隊與海峽偵巡，但仍依不挑釁、不怯敵、避免擦槍走火原則應處狀況，不希望誤解造成兩岸情勢不預期的反應。

                國防部表示，對於台海周邊海、空情相關動態，國軍運用聯合情監偵的作為，都能夠即時掌握，嚴密監控，確保國防安全。

                國防部說，共軍各項跨越海峽中線，進行軍事恫嚇的行為，已經嚴重破壞兩岸關係、衝擊區域和平穩定，並引發國際社會的不滿；國防部呼籲對岸應該要有所節制，珍惜和平，不要升高區域的情勢，破壞兩岸現狀。中共解放軍諸般蠻橫騷擾的行為，已經引起台灣人民的反感，也離台灣人民的民心越來越遠。國防部呼籲兩岸共同維護台海與印太區域的和平、穩定。
            </my:search>
        </h1>
        <hr>
        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>Symbol</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <my:stockList>
                    2330.TW,2317.TW,USDTWD=x
                </my:stockList>
            </tbody>
        </table>   
        <h1>
            <my:helloSimple msg="Java" />
        </h1>
        <h1>
            <my:add x="10" y="20" z="30" />
        </h1>
    </body>
</html>
