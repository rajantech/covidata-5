package com.example.covidata.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.covidata.R;
import com.example.covidata.pojo.*;
import com.example.covidata.*;
import com.squareup.picasso.Picasso;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class countriesAdapter extends RecyclerView.Adapter<countriesAdapter.ViewHolder> {
  //  List<pojoCountries>  listdata;
    //ArrayList<String> listdata ;
    List<pojoCountries>  listdata;
    Context context;
    String flag;

    // RecyclerView recyclerView;
    public countriesAdapter(Context context, List<pojoCountries> listdata) {

        this.listdata = listdata;
        this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.items, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
     pojoCountries myListData = listdata.get(position);

       // Toast.makeText(context, myListData.getCountries(), Toast.LENGTH_SHORT).show();

         flag = getFlag(myListData.getCountries());

        Picasso.with(context).load(flag).into(holder.flagOfCountry);



        holder.textView.setText(myListData.getCountries());
        holder.cases.setText(myListData.getCases());
        holder.newCases.setText("+"+myListData.getNewCases());

  holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(context,CountryData.class);
        intent.putExtra("cname",holder.textView.getText().toString());
        context.startActivity(intent);
    }
});



    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView cases;
        public  TextView newCases;
        public LinearLayout relativeLayout;
        ImageView flagOfCountry;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.country);
            this.cases = (TextView) itemView.findViewById(R.id.textView2);
            this.newCases = (TextView) itemView.findViewById(R.id.newCases);

            relativeLayout = (LinearLayout) itemView.findViewById(R.id.relativeLayout);
            this.flagOfCountry=itemView.findViewById(R.id.flagOfCountry);
        }
    }

    public String getFlag(String country)
    {
        if(country.equalsIgnoreCase("usa"))
        {return "https://disease.sh/assets/img/flags/us.png";
        }
        else   if(country.equalsIgnoreCase("brazil"))
        {
            return "https://disease.sh/assets/img/flags/br.png";
        }
        else   if(country.equalsIgnoreCase("russia"))
        {
            return "https://disease.sh/assets/img/flags/ru.png";
        }
        else   if(country.equalsIgnoreCase("india"))
        {
            return "https://disease.sh/assets/img/flags/in.png";
        }
        else   if(country.equalsIgnoreCase("uk"))
        {
            return "https://disease.sh/assets/img/flags/gb.png";
        }
        else   if(country.equalsIgnoreCase("spain"))
        {
            return "https://disease.sh/assets/img/flags/es.png";
        }
        else   if(country.equalsIgnoreCase("italy"))
        {
            return "https://disease.sh/assets/img/flags/it.png";
        }
        else   if(country.equalsIgnoreCase("peru"))
        {
            return "https://disease.sh/assets/img/flags/pe.png";
        }
        else   if(country.equalsIgnoreCase("germany"))
        {
            return "https://disease.sh/assets/img/flags/de.png";
        }
        else   if(country.equalsIgnoreCase("iran"))
        {
            return "https://disease.sh/assets/img/flags/ir.png";
        }
        else   if(country.equalsIgnoreCase("turkey"))
        {
            return "https://disease.sh/assets/img/flags/tr.png";
        }
        else   if(country.equalsIgnoreCase("chile"))
        {
            return "https://disease.sh/assets/img/flags/cl.png";
        }
        else   if(country.equalsIgnoreCase("france"))
        {
            return "https://disease.sh/assets/img/flags/fr.png";
        }
        else   if(country.equalsIgnoreCase("mexico"))
        {
            return "https://disease.sh/assets/img/flags/mx.png";
        }
        else   if(country.equalsIgnoreCase("pakistan"))
        {
            return "https://disease.sh/assets/img/flags/pk.png";
        }
        else   if(country.equalsIgnoreCase("saudi arabia"))
        {
            return "https://disease.sh/assets/img/flags/sa.png";
        }
        else   if(country.equalsIgnoreCase("canada"))
        {
            return "https://disease.sh/assets/img/flags/ca.png";
        }
        else   if(country.equalsIgnoreCase("bangladesh"))
        {
            return "https://disease.sh/assets/img/flags/bd.png";
        }
        else   if(country.equalsIgnoreCase("barbados"))
        {
            return "https://disease.sh/assets/img/flags/bb.png";
        }
        else   if(country.equalsIgnoreCase("belarus"))
        {
            return "https://disease.sh/assets/img/flags/by.png";
        }
        else   if(country.equalsIgnoreCase("belgium"))
        {
            return "https://disease.sh/assets/img/flags/be.png";
        }
        else   if(country.equalsIgnoreCase("belize"))
        {
            return "https://disease.sh/assets/img/flags/bz.png";
        }
        else   if(country.equalsIgnoreCase("benin"))
        {
            return "https://disease.sh/assets/img/flags/bj.png";
        }
        else   if(country.equalsIgnoreCase("bhutan"))
        {
            return "https://disease.sh/assets/img/flags/bt.png";
        }
        else   if(country.equalsIgnoreCase("bosnia"))
        {
            return "https://disease.sh/assets/img/flags/ba.png";
        }
        else   if(country.equalsIgnoreCase("botswana"))
        {
            return "https://disease.sh/assets/img/flags/bw.png";
        }
        else   if(country.equalsIgnoreCase("brazil"))
        {
            return "https://disease.sh/assets/img/flags/br.png";
        }
        else   if(country.equalsIgnoreCase("british virgin islands"))
        {
            return "https://disease.sh/assets/img/flags/vg.png";
        }
        else   if(country.equalsIgnoreCase("brunei"))
        {
            return "https://disease.sh/assets/img/flags/bn.png";
        }
        else   if(country.equalsIgnoreCase("bulgaria"))
        {
            return "https://disease.sh/assets/img/flags/bg.png";
        }
        else   if(country.equalsIgnoreCase("burkina faso"))
        {
            return "https://disease.sh/assets/img/flags/bf.png";
        }
        else   if(country.equalsIgnoreCase("burundi"))
        {
            return "https://disease.sh/assets/img/flags/bi.png";
        }
        else   if(country.equalsIgnoreCase("cabo Verde"))
        {
            return "https://disease.sh/assets/img/flags/cv.png";
        }
        else   if(country.equalsIgnoreCase("cambodia"))
        {
            return "https://disease.sh/assets/img/flags/kh.png";
        }
        else   if(country.equalsIgnoreCase("cameroon"))
        {
            return "https://disease.sh/assets/img/flags/cm.png";
        }
        else   if(country.equalsIgnoreCase("caribbean netherlands"))
        {
            return "https://disease.sh/assets/img/flags/bq.png";
        }
        else   if(country.equalsIgnoreCase("cyman islands"))
        {
            return "https://disease.sh/assets/img/flags/ky.png";
        }
        else   if(country.equalsIgnoreCase("central african republic"))
        {
            return "https://disease.sh/assets/img/flags/cf.png";
        }
        else   if(country.equalsIgnoreCase("chad"))
        {
            return "https://disease.sh/assets/img/flags/td.png";
        }
        else   if(country.equalsIgnoreCase("channel islands"))
        {
            return "https://disease.sh/assets/img/flags/je.png";
        }

        // else   if(country.equalsIgnoreCase(""))
        // {
        //   return "";
        // }

        else   if(country.equalsIgnoreCase("chile"))
        {
            return "https://disease.sh/assets/img/flags/cl.png";
        }
        else   if(country.equalsIgnoreCase("china"))
        {
            return "https://disease.sh/assets/img/flags/cn.png";
        }
        else if (country.equalsIgnoreCase("chile")) {
            return "https://disease.sh/assets/img/flags/cl.png";
        } else if (country.equalsIgnoreCase("china")) {
            return "https://disease.sh/assets/img/flags/cn.png";
        } else if (country.equalsIgnoreCase("colombia")) {
            return "https://disease.sh/assets/img/flags/co.png";
        } else if (country.equalsIgnoreCase("comoros")) {
            return "https://disease.sh/assets/img/flags/km.png";
        } else if (country.equalsIgnoreCase("congo")) {
            return "https://disease.sh/assets/img/flags/cg.png";
        } else if (country.equalsIgnoreCase("costa rica")) {
            return "https://disease.sh/assets/img/flags/cr.png";
        } else if (country.equalsIgnoreCase("croatia")) {
            return "https://disease.sh/assets/img/flags/hr.png";
        } else if (country.equalsIgnoreCase("cuba")) {
            return "https://disease.sh/assets/img/flags/cu.pn";
        } else if (country.equalsIgnoreCase("curacao")) {
            return "https://disease.sh/assets/img/flags/cw.png";
        }
        else if (country.equalsIgnoreCase("Netherlands")) {
            return "https://disease.sh/assets/img/flags/bq.png";
        }
        else if (country.equalsIgnoreCase("cyprus")) {
            return "https://disease.sh/assets/img/flags/cy.png";
        }
        else if (country.equalsIgnoreCase("czechia")) {
            return "https://disease.sh/assets/img/flags/cz.png";
        }
        else if (country.equalsIgnoreCase("curacao")) {
            return "https://disease.sh/assets/img/flags/cw.png";
        }
        else if (country.equalsIgnoreCase("qatar")) {
            return "https://disease.sh/assets/img/flags/qa.png";
        }
        else if (country.equalsIgnoreCase("south africa")) {
            return "https://disease.sh/assets/img/flags/za.png";
        }
        else if (country.equalsIgnoreCase("sweden")) {
            return "https://disease.sh/assets/img/flags/se.png";
        }
        else if (country.equalsIgnoreCase("Ecuador")) {
            return "https://disease.sh/assets/img/flags/ec.png";
        }
        else if (country.equalsIgnoreCase("uae")) {
            return "https://disease.sh/assets/img/flags/ae.png";
        }
        else if (country.equalsIgnoreCase("egypt")) {
            return "https://disease.sh/assets/img/flags/eg.png";
        }
        else if (country.equalsIgnoreCase("switzerland")) {
            return "https://disease.sh/assets/img/flags/ch.png";
        }
        else if (country.equalsIgnoreCase("singapore")) {
            return "https://disease.sh/assets/img/flags/sg.png";
        }
        else if (country.equalsIgnoreCase("indonesia")) {
            return "https://disease.sh/assets/img/flags/id.png";
        }
        else if (country.equalsIgnoreCase("portugal")) {
            return "https://disease.sh/assets/img/flags/pt.png";
        }
        else if (country.equalsIgnoreCase("kuwait")) {
            return "https://disease.sh/assets/img/flags/kw.png";
        }
        else if (country.equalsIgnoreCase("ukraine")) {
            return "https://disease.sh/assets/img/flags/ua.png";
        }
        else if (country.equalsIgnoreCase("Argentina")) {
            return "https://disease.sh/assets/img/flags/ar.png";
        }
        else if (country.equalsIgnoreCase("poland")) {
            return "https://disease.sh/assets/img/flags/pl.png";
        }
        else if (country.equalsIgnoreCase("ireland")) {
            return "https://disease.sh/assets/img/flags/ie.png";
        }
        else if (country.equalsIgnoreCase("philippines")) {
            return "https://disease.sh/assets/img/flags/ph.png";
        }
        else if (country.equalsIgnoreCase("afghanistan")) {
            return "https://disease.sh/assets/img/flags/af.png";
        }
        else if (country.equalsIgnoreCase("dominican republic")) {
            return "https://disease.sh/assets/img/flags/do.png";
        }
        else if (country.equalsIgnoreCase("romania")) {
            return "https://disease.sh/assets/img/flags/ro.png";
        }
        else if (country.equalsIgnoreCase("oman")) {
            return "https://disease.sh/assets/img/flags/om.png";
        }
        else if (country.equalsIgnoreCase("panama")) {
            return "https://disease.sh/assets/img/flags/pa.png";
        }
        else if (country.equalsIgnoreCase("israel")) {
            return "https://disease.sh/assets/img/flags/il.png";
        }
        else if (country.equalsIgnoreCase("iraq")) {
            return "https://disease.sh/assets/img/flags/iq.png";
        }
        else if (country.equalsIgnoreCase("japan")) {
            return "https://disease.sh/assets/img/flags/jp.png";
        }
        else if (country.equalsIgnoreCase("bolivia")) {
            return "https://disease.sh/assets/img/flags/bo.png";
        }
        else if (country.equalsIgnoreCase("bahrain")) {
            return "https://disease.sh/assets/img/flags/bh.png";
        }
        else if (country.equalsIgnoreCase("austria")) {
            return "https://disease.sh/assets/img/flags/at.png";
        }
        else if (country.equalsIgnoreCase("armenia")) {
            return "https://disease.sh/assets/img/flags/am.png";
        }
        else if (country.equalsIgnoreCase("austria")) {
            return "https://disease.sh/assets/img/flags/at.png";
        }
        else if (country.equalsIgnoreCase("nigeria")) {
            return "https://disease.sh/assets/img/flags/ng.png";
        }
        else if (country.equalsIgnoreCase("kazakhstan")) {
            return "https://disease.sh/assets/img/flags/kz.png";
        }
        else if (country.equalsIgnoreCase("serbia")) {
            return "https://disease.sh/assets/img/flags/rs.png";
        }
        else if (country.equalsIgnoreCase("denmark")) {
            return "https://disease.sh/assets/img/flags/dk.png";
        }
        else if (country.equalsIgnoreCase("s.korea")) {
            return "https://disease.sh/assets/img/flags/kr.png";
        }
        else if (country.equalsIgnoreCase("moldova")) {
            return "https://disease.sh/assets/img/flags/md.png";
        }
        else if (country.equalsIgnoreCase("ghana")) {
            return "https://disease.sh/assets/img/flags/gh.png";
        }
        else if (country.equalsIgnoreCase("algeria")) {
            return "https://disease.sh/assets/img/flags/dz.png";
        }
        else if (country.equalsIgnoreCase("azerbaijan")) {
            return "https://disease.sh/assets/img/flags/az.png";
        }

        else if (country.equalsIgnoreCase("guatemala")) {
            return "https://disease.sh/assets/img/flags/gt.png";
        }

        else if (country.equalsIgnoreCase("algeria")) {
            return "https://disease.sh/assets/img/flags/dz.png";
        }

        else if (country.equalsIgnoreCase("czechia")) {
            return "https://disease.sh/assets/img/flags/cz.png";
        }

        else if (country.equalsIgnoreCase("azerbaijan")) {
            return "https://disease.sh/assets/img/flags/az.png";
        }
        else if (country.equalsIgnoreCase("norway")) {
            return "https://disease.sh/assets/img/flags/no.png";
        }

        else if (country.equalsIgnoreCase("morocco")) {
            return "https://disease.sh/assets/img/flags/ma.png";
        }

        else if (country.equalsIgnoreCase("malaysia")) {
            return "https://disease.sh/assets/img/flags/dz.png";
        }

        else if (country.equalsIgnoreCase("honduras")) {
            return "https://disease.sh/assets/img/flags/hn.png";
        }
        else if (country.equalsIgnoreCase("australia")) {
            return "https://disease.sh/assets/img/flags/au.png";
        }

        else if (country.equalsIgnoreCase("finland")) {
            return "https://disease.sh/assets/img/flags/fi.png";
        }

        else if (country.equalsIgnoreCase(" south sudan")) {
            return "https://disease.sh/assets/img/flags/ss.png";
        }

        else if (country.equalsIgnoreCase("nepal")) {
            return "https://disease.sh/assets/img/flags/np.png";
        }

        else if (country.equalsIgnoreCase("Tajikistan")) {
            return "https://disease.sh/assets/img/flags/hn.png";
        }


        else if (country.equalsIgnoreCase("uzbekistan")) {
            return "https://disease.sh/assets/img/flags/tj.png";
        }

        else if (country.equalsIgnoreCase("senegal")) {
            return "https://disease.sh/assets/img/flags/sn.png";
        }

        else if (country.equalsIgnoreCase("ivory coast" )) {
            return "https://disease.sh/assets/img/flags/ci.png";
        }

        else if (country.equalsIgnoreCase("drc")) {
            return "https://disease.sh/assets/img/flags/cd.png";
        }

        else if (country.equalsIgnoreCase("djibouti")) {
            return "https://disease.sh/assets/img/flags/dj.png";
        }

        else if (country.equalsIgnoreCase("guinea")) {
            return "https://disease.sh/assets/img/flags/gq.png";
        }

        else if (country.equalsIgnoreCase("luxembourg")) {
            return "https://disease.sh/assets/img/flags/lu.png";
        }

        else if (country.equalsIgnoreCase("hungary")) {
            return "https://disease.sh/assets/img/flags/hu.png";
        }

        else if (country.equalsIgnoreCase("haiti")) {
            return "https://disease.sh/assets/img/flags/ht.png";
        }

        else if (country.equalsIgnoreCase("north macedonia")) {
            return "https://disease.sh/assets/img/flags/mk.png";
        }

        else if (country.equalsIgnoreCase("e1 salvador")) {
            return "https://disease.sh/assets/img/flags/sv.png";
        }

        else if (country.equalsIgnoreCase("gabon")) {
            return "https://disease.sh/assets/img/flags/ga.png";
        }

        else if (country.equalsIgnoreCase("kenya")) {
            return "https://disease.sh/assets/img/flags/ke.png";
        }

        else if (country.equalsIgnoreCase("bulgaria")) {
            return "https://disease.sh/assets/img/flags/bg.png";
        }

        else if (country.equalsIgnoreCase("thailand")) {
            return "https://disease.sh/assets/img/flags/th.png";
        }

        else if (country.equalsIgnoreCase("greece")) {
            return "https://disease.sh/assets/img/flags/gr.png";
        }

        else if (country.equalsIgnoreCase("ethiopia")) {
            return "https://disease.sh/assets/img/flags/et.png";
        }

        else if (country.equalsIgnoreCase("bosnia and herzegovina")) {
            return "https://disease.sh/assets/img/flags/ba.png";
        }

        else if (country.equalsIgnoreCase("venezuela")) {
            return "https://disease.sh/assets/img/flags/ve.png";
        }

        else if (country.equalsIgnoreCase("somalia")) {
            return "https://disease.sh/assets/img/flags/so.png";
        }

        else if (country.equalsIgnoreCase("mayotte")) {
            return "https://disease.sh/assets/img/flags/yt.png";
        }


        else if (country.equalsIgnoreCase("kyrgyzstan")) {
            return "https://disease.sh/assets/img/flags/kg.png";
        }


        else if (country.equalsIgnoreCase("car")) {
            return "https://disease.sh/assets/img/flags/cf.png";
        }


        else if (country.equalsIgnoreCase("maldives")) {
            return "https://disease.sh/assets/img/flags/mv.png";
        }


        else if (country.equalsIgnoreCase("estonia")) {
            return "https://disease.sh/assets/img/flags/ee.png";
        }



        else if (country.equalsIgnoreCase("sri lanka")) {
            return "https://disease.sh/assets/img/flags/lk.png";
        }

        else if (country.equalsIgnoreCase("iceland")) {
            return "https://disease.sh/assets/img/flags/is.png";
        }

        else if (country.equalsIgnoreCase("lithuania")) {
            return "https://disease.sh/assets/img/flags/lt.png";
        }

        else if (country.equalsIgnoreCase("mali")) {
            return "https://disease.sh/assets/img/flags/ml.png";
        }
        else if (country.equalsIgnoreCase("south sudan")) {
            return "https://disease.sh/assets/img/flags/ss.png";
        }
        else if (country.equalsIgnoreCase("mauritania")) {
            return "https://disease.sh/assets/img/flags/mr.png";
        }
        else if (country.equalsIgnoreCase("slovakia")) {
            return "https://disease.sh/assets/img/flags/sk.png";
        }
        else if (country.equalsIgnoreCase("newzealand")) {
            return "https://disease.sh/assets/img/flags/.png";
        }
        else if (country.equalsIgnoreCase("slovenia")) {
            return "https://disease.sh/assets/img/flags/si.png";
        }
        else if (country.equalsIgnoreCase("nicaragua")) {
            return "https://disease.sh/assets/img/flags/ni.png";
        }
        else if (country.equalsIgnoreCase("guinea-bissau")) {
            return "https://disease.sh/assets/img/flags/gw.png";
        }
        else if (country.equalsIgnoreCase("lebanon")) {
            return "https://disease.sh/assets/img/flags/lb.png";
        }
        else if (country.equalsIgnoreCase("equatorial guinea")) {
            return "https://disease.sh/assets/img/flags/gq.png";
        }
        else if (country.equalsIgnoreCase("paraguay")) {
            return "https://disease.sh/assets/img/flags/py.png";
        }
        else if (country.equalsIgnoreCase("madagascar")) {
            return "https://disease.sh/assets/img/flags/mg.png";
        }
        else if (country.equalsIgnoreCase("hong kong")) {
            return "https://disease.sh/assets/img/flags/hk.png";
        }
        else if (country.equalsIgnoreCase("sierra leone")) {
            return "https://disease.sh/assets/img/flags/sz.png";
        }
        else if (country.equalsIgnoreCase("latvia")) {
            return "https://disease.sh/assets/img/flags/lv.png";
        }
        else if (country.equalsIgnoreCase("tunisia")) {
            return "https://disease.sh/assets/img/flags/tn.png";
        }
        else if (country.equalsIgnoreCase("french guiana")) {
            return "https://disease.sh/assets/img/flags/gf.png";
        }
        else if (country.equalsIgnoreCase("niger")) {
            return "https://disease.sh/assets/img/flags/ne.png";
        }
        else if (country.equalsIgnoreCase("jordan")) {
            return "https://disease.sh/assets/img/flags/ss.png";
        }
        else if (country.equalsIgnoreCase("andorra")) {
            return "https://disease.sh/assets/img/flags/ss.png";
        }

        else if (country.equalsIgnoreCase("uruguay")) {
            return "https://disease.sh/assets/img/flags/ss.png";
        }
        else if (country.equalsIgnoreCase("georgia")) {
            return "https://disease.sh/assets/img/flags/jo.png";
        }

        else if (country.equalsIgnoreCase("diamond princess")) {
            return "https://disease.sh/assets/img/flags/unknown.png";
        }
        else if (country.equalsIgnoreCase("san marnio")) {
            return "https://disease.sh/assets/img/flags/sm.png";
        }
        else if (country.equalsIgnoreCase("uganada")) {
            return "https://disease.sh/assets/img/flags/ug.png";
        }
        else if (country.equalsIgnoreCase("malta")) {
            return "https://disease.sh/assets/img/flags/mt.png";
        }
        else if (country.equalsIgnoreCase("sao tome and principle")) {
            return "https://disease.sh/assets/img/flags/st.png";
        }
        else if (country.equalsIgnoreCase("yemen")) {
            return "https://disease.sh/assets/img/flags/ye.png";
        }
        else if (country.equalsIgnoreCase("jamaica")) {
            return "https://disease.sh/assets/img/flags/jm.png";
        }
        else if (country.equalsIgnoreCase("togo")) {
            return "https://disease.sh/assets/img/flags/tg.png";
        }
        else if (country.equalsIgnoreCase("rwanda")) {
            return "https://disease.sh/assets/img/flags/rw.png";
        }
        else if (country.equalsIgnoreCase("tanzania")) {
            return "https://disease.sh/assets/img/flags/tz.png";
        }
        else if (country.equalsIgnoreCase("mozambique")) {
            return "https://disease.sh/assets/img/flags/mz.png";
        }
        else if (country.equalsIgnoreCase("palestine")) {
            return "https://disease.sh/assets/img/flags/ps.png";
        }
        else if (country.equalsIgnoreCase("reunion")) {
            return "https://disease.sh/assets/img/flags/re.png";
        }
        else if (country.equalsIgnoreCase("malawi")) {
            return "https://disease.sh/assets/img/flags/mw.png";
        }
        else if (country.equalsIgnoreCase("eswatini")) {
            return "https://disease.sh/assets/img/flags/.png";
        }
        else if (country.equalsIgnoreCase("taiwan")) {
            return "https://disease.sh/assets/img/flags/tw.png";
        }
        else if (country.equalsIgnoreCase("liberia")) {
            return "https://disease.sh/assets/img/flags/lr.png";
        }
        else if (country.equalsIgnoreCase("libya")) {
            return "https://disease.sh/assets/img/flags/ly.png";
        }
        else if (country.equalsIgnoreCase("zimbabwe")) {
            return "https://disease.sh/assets/img/flags/zw.png";
        }
        else if (country.equalsIgnoreCase("mauritius")) {
            return "https://disease.sh/assets/img/flags/mu.png";
        }
        else if (country.equalsIgnoreCase("isle of man")) {
            return "https://disease.sh/assets/img/flags/im.png";
        }
        else if (country.equalsIgnoreCase("vietnam")) {
            return "https://disease.sh/assets/img/flags/vn.png";
        }
        else if (country.equalsIgnoreCase("montenegro")) {
            return "https://disease.sh/assets/img/flags/me.png";
        }
        else if (country.equalsIgnoreCase("myanmar")) {
            return "https://disease.sh/assets/img/flags/mm.png";
        }
        else if (country.equalsIgnoreCase("martinique")) {
            return "https://disease.sh/assets/img/flags/mq.png";
        }
        else if (country.equalsIgnoreCase("mongolia")) {
            return "https://disease.sh/assets/img/flags/mn.png";
        }
        else if (country.equalsIgnoreCase("suriname")) {
            return "https://disease.sh/assets/img/flags/sr.png";
        }
        else if (country.equalsIgnoreCase("cayman islands")) {
            return "https://disease.sh/assets/img/flags/ky.png";
        }
        else if (country.equalsIgnoreCase("faeroe islands")) {
            return "https://disease.sh/assets/img/flags/unknown.png";
        }
        else if (country.equalsIgnoreCase("gibraltar")) {
            return "https://disease.sh/assets/img/flags/gi.png";
        }
        else if (country.equalsIgnoreCase("guadeloupe")) {
            return "https://disease.sh/assets/img/flags/gp.png";
        }
        else if (country.equalsIgnoreCase("syria")) {
            return "https://disease.sh/assets/img/flags/sy.png";
        }
        else if (country.equalsIgnoreCase("guyana")) {
            return "https://disease.sh/assets/img/flags/gy.png";
        }
        else if (country.equalsIgnoreCase("bermuda")) {
            return "https://disease.sh/assets/img/flags/bm.png";
        }
        else if (country.equalsIgnoreCase("angola")) {
            return "https://disease.sh/assets/img/flags/ao.png";
        }
        else if (country.equalsIgnoreCase("trinidad and tobago")) {
            return "https://disease.sh/assets/img/flags/tt.png";
        }
        else if (country.equalsIgnoreCase("bahamas")) {
            return "https://disease.sh/assets/img/flags/bs.png";
        }
        else if (country.equalsIgnoreCase("aruba")) {
            return "https://disease.sh/assets/img/flags/aw.png";
        }
        else if (country.equalsIgnoreCase("monaco")) {
            return "https://disease.sh/assets/img/flags/mc.png";
        }
        else if (country.equalsIgnoreCase("liechtenstein")) {
            return "https://disease.sh/assets/img/flags/li.png";
        }
        else if (country.equalsIgnoreCase("sint maarten")) {
            return "https://disease.sh/assets/img/flags/sx.png";
        }
        else if (country.equalsIgnoreCase("french polynesia")) {
            return "https://disease.sh/assets/img/flags/pf.png";
        }
        else if (country.equalsIgnoreCase("macao")) {
            return "https://disease.sh/assets/img/flags/mo.png";
        }
        else if (country.equalsIgnoreCase("saint martin")) {
            return "https://disease.sh/assets/img/flags/mf.png";
        }
        else if (country.equalsIgnoreCase("eritrea")) {
            return "https://disease.sh/assets/img/flags/er.png";
        }
        else if (country.equalsIgnoreCase("namibia")) {
            return "https://disease.sh/assets/img/flags/na.png";
        }
        else if (country.equalsIgnoreCase("gambia")) {
            return "https://disease.sh/assets/img/flags/gm.png";
        }
        else if (country.equalsIgnoreCase("st.vincent grenadines")) {
            return "https://disease.sh/assets/img/flags/unknown.png";
        }
        else if (country.equalsIgnoreCase("antigua and barbuda")) {
            return "https://disease.sh/assets/img/flags/ag.png";
        }
        else if (country.equalsIgnoreCase("timor-leste")) {
            return "https://disease.sh/assets/img/flags/tl.png";
        }
        else if (country.equalsIgnoreCase("grenada")) {
            return "https://disease.sh/assets/img/flags/gd.png";
        }
        else if (country.equalsIgnoreCase("curacao")) {
            return "https://disease.sh/assets/img/flags/cw.png";
        }
        else if (country.equalsIgnoreCase("new caledonia")) {
            return "https://disease.sh/assets/img/flags/nc.png";
        }
        else if (country.equalsIgnoreCase("laos")) {
            return "https://disease.sh/assets/img/flags/la.png";
        }
        else if (country.equalsIgnoreCase("saint lucia")) {
            return "https://disease.sh/assets/img/flags/lc.png";
        }
        else if (country.equalsIgnoreCase("dominica")) {
            return "https://disease.sh/assets/img/flags/dm.png";
        }
        else if (country.equalsIgnoreCase("fiji")) {
            return "https://disease.sh/assets/img/flags/fj.png";
        }
        else if (country.equalsIgnoreCase("saint kitts and nevis")) {
            return "https://disease.sh/assets/img/flags/kn.png";
        }
        else if (country.equalsIgnoreCase("falkland islands")) {
            return "https://disease.sh/assets/img/flags/fk.png";
        }
        else if (country.equalsIgnoreCase("greenland")) {
            return "https://disease.sh/assets/img/flags/gl.png";
        }
        else if (country.equalsIgnoreCase("turks and caicos")) {
            return "https://disease.sh/assets/img/flags/tc.png";
        }
        else if (country.equalsIgnoreCase("vatican city")) {
            return "https://disease.sh/assets/img/flags/va.png";
        }
        else if (country.equalsIgnoreCase("montserrat")) {
            return "https://disease.sh/assets/img/flags/ms.png";
        }
        else if (country.equalsIgnoreCase("seychelles")) {
            return "https://disease.sh/assets/img/flags/sc.png";
        }
        else if (country.equalsIgnoreCase("ms zaandam")) {
            return "https://disease.sh/assets/img/flags/unknown.png";
        }
        else if (country.equalsIgnoreCase("western sahara")) {
            return "https://disease.sh/assets/img/flags/eh.png";
        }
        else if (country.equalsIgnoreCase("papua new guinea")) {
            return "https://disease.sh/assets/img/flags/pg.png";
        }
        else if (country.equalsIgnoreCase("st.barth")) {
            return "https://disease.sh/assets/img/flags/st.png";
        }
        else if (country.equalsIgnoreCase("lesotho")) {
            return "https://disease.sh/assets/img/flags/ls.png";
        }
        else if (country.equalsIgnoreCase("anguilla")) {
            return "https://disease.sh/assets/img/flags/ai.png";
        } else if (country.equalsIgnoreCase("saint pierre miquelon")) {
            return "https://disease.sh/assets/img/flags/lc.png";
        }

        else{
            return "https://disease.sh/assets/img/flags/br.png";
        }
    }



}

