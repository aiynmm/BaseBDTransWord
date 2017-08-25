package com.sinosoft.basebdtransword.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sinosoft.basebdtransword.R;

/**
 * Created by Mars on 2017/6/12.
 */
        /*【史部】
        三家注史记汉书后汉书 李贤注后汉书三国志 裴松之注晋书宋书南齐书梁书陈书魏书北齐书周书北史南史隋书旧唐书新唐书旧五代史新五代史
        宋史辽史金史元史明史清史稿新元史史記漢書 顏師古注後漢書 李賢注晉書宋書南齊書梁書陳書魏書
        【子部】
        郭店楚墓竹简明夷待访录典论新论荀子佛祖通载释氏稽古略五灯会元林间录宋高僧传开元释教录古尊宿语录法苑珠林六祖大师法宝坛经佛说四十二章经碧岩录抱朴子内篇罗湖野录素书老子集注历代崇道记僧宝传亢仓子通玄真经庄子·内篇云笈七签太平经合校老子道德经校释列仙传列子道德经（老子）老子道德经(英译本)Lao Tze庄子黄帝阴符经庄子集释关尹子
        【集部】
        文史通义汉魏南北朝墓志汇编弘明集广弘明集笑林广记唐文续拾全齐文唐文拾遗全宋文全唐文全晋文先唐文全三国文宋诗一百首全隋文全后汉文唐诗三百首全后周文全汉文薛涛、李冶诗集全北齐文全秦文箧中集全后魏文全上古三代文全陈文全梁文昭明文选全汉诗嵇康诗全集古文观止文忠集阮籍诗全集双江聂先生文集刘桢诗全集诗 (历代诸家)
        【诗部】
        声律启蒙笠翁对韵千家诗全唐诗十八家诗抄乐府诗集古诗源先秦汉魏晋南北朝诗古谣谚玉台新咏楚辞补註楚辞文心雕龙译注曹组词集饮水词范成大词集茶联集锦断肠词平水韵部梅溪词词韵简编竹斋诗余词格律婉约词龙洲词白朴集姜夔词选蒲江词白石道人歌曲漱玉词知稼翁词平斋词无住词樵隐词酒边词片玉词
        【儒部】
        小学诗家范 (全译评点本)潜夫论笺校正幼学琼林二十四孝传习录鉴略妥注盐铁论朱子语类小儿语申鉴张子正蒙训蒙骈句说苑西铭新序名贤集新书弟子规中论春秋繁露三字经法言义疏孔丛子孔子家语增广贤文读书分年日程朱子治家格言北溪字义围炉夜话袁氏世范菜根谭新語(简繁对照)呻吟语摘陆贾新语注释知言
        【易部】
        青囊奥语撼龙经灵城精义三命通会葬书月波洞中记天玉经宅经太玄经周易周易正义东坡易传子夏易传周易郑康成注新本郑氏周易陆氏易解周易略例周易集解易童子问周易正义陸氏易解易纬坤灵图易纬乾元序制记冰鉴测字秘牒天玉经内传心相篇宅经了斋易说京氏易传伊川易传周易举正周易口义周易口诀义周易新讲义周易本义
        【艺部】
        禾谱画继林泉高致集棋经论象棋十诀茶录棋经桔中秘叙茶疏书断列传梅花谱煮泉小品古画品录象棋指归阳羡茗壶系棋经十三篇茶经(今注)益州名画录茶经随园食单画禅室随笔北山酒经乐府杂录橘录古今刀剑录岕茶汇抄北苑别录洛阳牡丹记大明水記宣和北苑贡茶录禽经東茶記茶賦 幷書茶神傳十六湯品東茶頌*/

public class BookNameAdapter extends RecyclerView.Adapter<BookNameAdapter.MyBookViewHolder> {
    private LayoutInflater inflater;
    private String[] data = {"三家注史记", "汉书", "后汉书 李贤注", "后汉书", "三国志 裴松之注",
            "晋书", "宋书", "南齐书", "梁书", "陈书", "魏书", "北齐书", "周书", "北史", "南史", "隋书",
            "旧唐书", "新唐书", "旧五代史", "新五代", "宋史", "辽史", "金史", "元史", "明史", "清史稿", "新元史"
            , "漢書 顏師古注", "後漢書 李賢注", "晉書", "宋書", "南齊書", "梁書", "陳書", "魏書"

    };

    public BookNameAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public MyBookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.book_item, parent, false);
        return new MyBookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyBookViewHolder holder, int position) {
        holder.bookname.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class MyBookViewHolder extends RecyclerView.ViewHolder {
        TextView bookname;

        public MyBookViewHolder(View itemView) {
            super(itemView);
            bookname = (TextView) itemView.findViewById(R.id.book_name);
        }
    }
}
