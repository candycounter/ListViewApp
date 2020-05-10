package com.example.orientationproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout layout;
    ListView listView;
    String strMadden;
    String strNumber;
    String strDraft;
    int selectedTextColor;
    int selectedBackColor;
    ArrayList<QuarterBacks> arrayList;
    TextView description;
    TextView team;
    TextView jerseyNumber;
    TextView draftYear;
    int selecteditem = 0;
    String strTeam;
    public static final String KEY_LIST = "a";
    TextView maddenRating;
    public static final String KEY_MADDEN_RATING = "b";
    public static final String KEY_SELECTED = "c";
    public static final String KEY_TEAM = "d";
    public static final String KEY_NUMBER = "e";
    public static final String KEY_BACKGROUND = "f";
    public static final String KEY_TEXT = "g";
    public static final String KEY_YEAR = "h";
    int pos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.id_constraint_layout);
        listView = findViewById(R.id.id_listview);
        description = findViewById(R.id.id_land_textView);
        jerseyNumber = findViewById(R.id.id_jersey_number);
        maddenRating = findViewById(R.id.id_Madden_Rating);
        draftYear = findViewById(R.id.id_draft_year);
        team = findViewById(R.id.id_team);

        arrayList = new ArrayList<>();
        arrayList.add(new QuarterBacks("Lamar Jackson",8, R.drawable.lamar, "Doubted by everyone when he was first drafted, including myself. He looked more like a WR than QB. However, he has been proving everyone wrong due to his ridiculous growth in his second year. Fan-favorite due to his refusal to put himself higher than his teammates. The overwhelming favorite to win MVP but only focused on winning the Super Bowl. The longevity of his career is in question as QBs with similar playing styles have flamed out quickly.", "Baltimore Ravens", 2018,90,Color.parseColor("#241773"),Color.parseColor("#9E7C0C")));
        arrayList.add(new QuarterBacks("Patrick Mahomes",15,R.drawable.patrick, "The Bears regret not taking this generational QB. Mahomes spent his rookie season learning the playbook for the Chiefs. Then, he exploded the next year when he posted over 5000 yards in passing and 50 touchdowns. Both stats are extremely rare for a QB. Has talents that I have never seen before. Only issue is that he always looks for the big-plays, which is not the best case everytime. Mahomes is very young and will be battling with Lamar Jackson for Best QB of the next era.","Kansas City Chiefs",2017,99, Color.parseColor("#CA2430"), Color.parseColor("#FFB612")));
        arrayList.add(new QuarterBacks("Russell Wilson",3,R.drawable.russ,"Wilson was doubted by everyone when he was first drafted due to his short height. However, his coach chose heart over height and started Wilson his rookie year. Seahawks were given an F for their draft class. However, Wilson made them eat his words as he led his Seahawks to the playoffs his rookie year and won Super Bowl 48 the following year. Somehow still alive after dealing with middle-school caliber offensive lines for years. Only problem with Wilson was that he gave the patriots Super Bowl 49 when he threw the ball at the 1 yd line, despite having Marshawn Lynch. Despite that mistake and horrible offensive lines through the years, Wilson is still an All-pro QB.","Seattle Seahawks", 2012,97,Color.parseColor("#002244"), Color.parseColor("#69BE28")));
        arrayList.add(new QuarterBacks("Aaron Rodgers",12,R.drawable.rodgers, "2X MVP. Super Bowl 45 MVP. Has a knack of making comebacks and pulling off ridiculous Hail Marys. Never give this man enough time in the pocket as he will undoubtedly torch you every time. Arugably the most accurate QB in NFL history as he rarely throws interceptions. Few concerns are that he is 35 years old and that his shoulders are made of toothpicks and always pouts about the coach","Green Bay Packers",2005,91, Color.parseColor("#203731"), Color.parseColor("#FFB612")));
        arrayList.add(new QuarterBacks("Tom Brady",12, R.drawable.brady,"6X Super Bowl Champion, 4X Super Bowl MVP. Coached by the greatest coach of all time and is considered the best to play. Never count this man out, no matter the score of the game. Whether it's the first quarter or fourth quarter, Brady will find a way to win the game. Just ask Matt Ryan and the Falcons. However, he has regressed tremendously and relies on the defense for wins. Also, he cannot beat the giants and has been involved in cheating scandals.","New England Patriots",2000,96,Color.parseColor("#002244"), Color.parseColor("#C60C30")));
        arrayList.add(new QuarterBacks("Drew Brees",9,R.drawable.brees,"Mr.Passing Yds leader. Second oldest QB behind Tom Brady yet he plays like he is 26. Despite playing his best for the Saints, he is always screwed by his defense and horrible officiating. Super Bowl 44 MVP but would have won Super Bowl 53 MVP if it was not for the refs screwing his team over. Might be the best volume passer in NFL history.", "New Orleans Saints",2001,92,Color.parseColor("#D3BC8D"), Color.parseColor("#101820")));
        arrayList.add(new QuarterBacks("Daniel Jones",8,R.drawable.dimes,"One of the most controversial draft picks in NFL History. Harassed constantly by every fanbase except for the New York Giants. He is very young and still has lots of time to develop. He would be a baller if it was not for his stupid coach and GM. Main problem is holding onto the football.","New York Giants",2019,69, Color.parseColor("#0B2265"),Color.parseColor("#A71930")));
        arrayList.add(new QuarterBacks("Kirk Cousins", 12, R.drawable.cousins, "You either love this guy or absolutely hate him. Cousins showed this year that he is a reliable option, but he still never shows up on prime time games. He has an 0-8 record on Monday Night Football, but it's not even prime time as no one watches due to the day being a Monday and the poor commentary team. Anyways, his bounce back season is due to the emergence of Dalvin Cook. The emergence has opened up the offense and has the Vikings as a potential Super Bowl Contender.", "Minnesota Vikings", 2012,83, Color.parseColor("#4F2683"),Color.parseColor("#FFC62F")));
        arrayList.add(new QuarterBacks("Dak Prescott",4,R.drawable.dak, "Surprised everyone when he emerged out of nowhere to replace an injured Tony Romo. That was the best move as Romo is now the GOAT at commentating. Anyways, he regressed after winning Offensive Rookie of the Year, throwing bone headed passes and not finding ways to win games. This offseason, he demanded that he receives $40 million a year, LOL. He would be liked more if he was not playing on the Cowboys. But because of a clap-happy head coach and an egotistical owner, he is widely disliked throughout America.", "Dallas Cowboys",2016,83,  Color.parseColor("#041E42"), Color.parseColor("#869397")));
        arrayList.add(new QuarterBacks("Jared Goff", 16, R.drawable.goff, "Selected as the first overall pick in the 2016 draft, over Carson Wentz. Completely horrible his rookie season due to a poor coaching staff. However, with the hiring of Sean McVay, an offenseive guru, Goff blossomed into a star QB in the next two seasons. Led the Rams to Super Bowl 53 where they played like trash against the Patriots. Goff was unable to generate any offense and threw game-ending pick to Stephon Gilmore. Regressed this season but has been playing well as of late.", "Los Angeles Rams", 2016,77, Color.parseColor("#002D72"), Color.parseColor("#FFCD00")));
        arrayList.add(new QuarterBacks("Carson Wentz",11,R.drawable.carson,"Second overall pick in the 2016 draft. Started off slow and broke out into an MVP-caliber player the following year, but it came to a close when he tore his ACL at the end of the season. He was never the same after that injury as he suffered more injuries and regressed tremendously. He got paid $128 million to throw passes to the ground or the other team.","Philadelphia Eagles",2016,82, Color.parseColor("#004C54"), Color.parseColor("#A5ACAF")));
        arrayList.add(new QuarterBacks("Matt Ryan",2,R.drawable.ryan, "One of the more reliable QBs of this decade. Had a breakout 2016 season that led to his first MVP. He was on his way to winning Super Bowl 51 when he decided to implode and blow a 28-3 lead to the New England Patriots. That loss hit him and the organization hard as they were never the same after that. Probably a Hall of Famer, but also overrated and overpaid", "Atlanta Falcons",2008,87, Color.parseColor("#A71930"), Color.parseColor("#000000")));
        arrayList.add(new QuarterBacks("Baker Mayfield",6,R.drawable.baker, "First overall pick in the 2018 NFL Draft. Has the swagger, confidence, and poise to lead an NFL team. However, he is arrogant, cocky, and annoying. Throws more jabs at the media than touchdowns and has more garbage commericals than wins. He still has a long career ahead of him but he might flame out due to his attitude and inability to throw the ball to his star WRs.", "Cleveland Browns",2018,78, Color.parseColor("#311D00"), Color.parseColor("#FF3C00")));
        arrayList.add(new QuarterBacks("Philip Rivers",17,R.drawable.rivers, "One of the older QBs that has stuck around for a long time. Led his teams to playoffs but always found a way to lose due to Special Teams. Rivers acts like a 2 year old on the field as he pouts for penalties non-stop. He also specializes in breeding kids as he plans on having 42 more after he is done playing, so that he can have a full 53 man roster", "Los Angeles Chargers",2004,85, Color.parseColor("#0080C6"), Color.parseColor("#FFC20E")));
        arrayList.add(new QuarterBacks("Deshaun Watson",4, R.drawable.deshaun,"Drafted two picks after Patrick Mahomes. Had an MVP-type rookie season that was cut short due to a knee injury. Despite that, he has rebounded and became an MVP candidate once again this season. His GM (there is none) and his coach are responsible for any potential injuries this kid might have later on his career as they have failed to give this savior an offensive line. ", "Houston Texans", 2017,86, Color.parseColor("#03202F"), Color.parseColor("#A71930")));
        arrayList.add(new QuarterBacks("Ben Roethlisberger",7,R.drawable.ben,"2X Super Bowl Champion. Despite being large for QB, he has been reliable throughout his career. He is not liked by some of his former teammates as they believed that he was power-hungry. Just ask Antonio Brown, who is unleashing idiotic tweets left and right. Has not won anything as of late in his career and suffered a potential career-ending injury.", "Pittsburgh Steelers",2007, 81, Color.parseColor("#000000"), Color.parseColor("#FFB612")));



        if(savedInstanceState != null)
        {
            arrayList = (ArrayList<QuarterBacks>) savedInstanceState.getSerializable(KEY_LIST);
            strMadden = savedInstanceState.getString(KEY_MADDEN_RATING);
            maddenRating.setText(strMadden);

            strTeam = savedInstanceState.getString(KEY_TEAM);
            team.setText(strTeam);

            strNumber = savedInstanceState.getString(KEY_NUMBER);
            jerseyNumber.setText(strNumber);

            strDraft = savedInstanceState.getString(KEY_YEAR);
            draftYear.setText(strDraft);


            selecteditem = savedInstanceState.getInt(KEY_SELECTED);
            selectedTextColor = savedInstanceState.getInt(KEY_TEXT);
            selectedBackColor = savedInstanceState.getInt(KEY_BACKGROUND);
            if(selecteditem !=0) {
                layout.setBackgroundColor(selectedBackColor);
                jerseyNumber.setTextColor(selectedTextColor);
                team.setTextColor(selectedTextColor);
                maddenRating.setTextColor(selectedTextColor);
                draftYear.setTextColor(selectedTextColor);
            }
            if(description!=null) {
                description.setText(arrayList.get(selecteditem).getDescrip());
                description.setTextColor(arrayList.get(selecteditem).getTextColor());
            }
        }

        CustomAdapter customAdapter  = new CustomAdapter(this,R.layout.adapter_custom ,arrayList);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selecteditem = position;
                layout.setBackgroundColor(arrayList.get(selecteditem).getBackgroundColor());

                maddenRating.setText("Madden 20 Rating: "+arrayList.get(selecteditem).getMaddenRating());
                maddenRating.setTextColor(arrayList.get(selecteditem).getTextColor());

                jerseyNumber.setText("Jersey #: "+arrayList.get(selecteditem).getNumber());
                jerseyNumber.setTextColor(arrayList.get(selecteditem).getTextColor());

                team.setText("Team: "+arrayList.get(selecteditem).getTeam());
                team.setTextColor(arrayList.get(selecteditem).getTextColor());

                draftYear.setText("Year Drafted: "+arrayList.get(selecteditem).getDraftYear());
                draftYear.setTextColor(arrayList.get(selecteditem).getTextColor());

                if(description!=null) {
                    description.setText(arrayList.get(selecteditem).getDescrip());
                    description.setTextColor(arrayList.get(selecteditem).getTextColor());
                }

            }
        });
        if(arrayList.size() == 1) {
            layout.setBackgroundColor(arrayList.get(0).getBackgroundColor());

            maddenRating.setText("Madden 20 Rating: " + arrayList.get(0).getMaddenRating());
            maddenRating.setTextColor(arrayList.get(0).getTextColor());

            jerseyNumber.setText("Jersey #: " + arrayList.get(0).getNumber());
            jerseyNumber.setTextColor(arrayList.get(0).getTextColor());

            team.setText("Team: " + arrayList.get(0).getTeam());
            team.setTextColor(arrayList.get(0).getTextColor());

            draftYear.setText("Year Drafted: " + arrayList.get(0).getDraftYear());
            draftYear.setTextColor(arrayList.get(0).getTextColor());

            if (description != null) {
                description.setText(arrayList.get(0).getDescrip());
                description.setTextColor(arrayList.get(0).getTextColor());

            }
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_MADDEN_RATING,maddenRating.getText().toString());
        outState.putSerializable(KEY_LIST, arrayList);
        outState.putInt(KEY_SELECTED, selecteditem);
        outState.putString(KEY_TEAM, team.getText().toString());
        outState.putString(KEY_NUMBER, jerseyNumber.getText().toString());
        outState.putInt(KEY_BACKGROUND, arrayList.get(selecteditem).getBackgroundColor());
        outState.putInt(KEY_TEXT, arrayList.get(selecteditem).getTextColor());
        outState.putString(KEY_YEAR, draftYear.getText().toString());
    }

    public class CustomAdapter extends ArrayAdapter<QuarterBacks> {

        List<QuarterBacks>list;
        Context context;
        int xmlResource;

        public CustomAdapter(@NonNull Context context, int resource, @NonNull List<QuarterBacks>objects) {
            super(context, resource, objects);
            this.context = context;
            xmlResource = resource;
            list = objects;

        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View adapterView = layoutInflater.inflate(xmlResource, null);
            TextView textView = adapterView.findViewById(R.id.id_adapter_text);
            ImageView imageView = adapterView.findViewById(R.id.id_adapter_imageView);
            Button button = adapterView.findViewById(R.id.id_adapter_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pos = position;
                    arrayList.remove(pos);
                    notifyDataSetChanged();
                }
            });

            textView.setText(list.get(position).getName());
            imageView.setImageResource(list.get(position).getIdQB());
            textView.setTextColor(list.get(position).getTextColor());
            adapterView.setBackgroundColor(list.get(position).getBackgroundColor());
            button.setTextColor(list.get(position).getBackgroundColor());
            button.setBackgroundColor(list.get(position).getTextColor());


            return adapterView;
        }


    }

    public class QuarterBacks implements Serializable
    {
        private String name;
        private int draftyear;
        private int idQB;
        private String descrip;
        private String team;
        private int number;
        private int backgroundColor;
        private int textColor;
        private int maddenRating;
        public QuarterBacks(String name, int number, int idQB, String descrip, String team, int draftyear, int maddenRating, int backgroundColor, int textColor)
        {
            this.name = name;
            this.number = number;
            this.idQB = idQB;
            this.descrip = descrip;
            this.team = team;
            this.maddenRating = maddenRating;
            this.backgroundColor = backgroundColor;
            this.textColor = textColor;
            this.draftyear = draftyear;

        }

        public String getName()
        {
            return name;
        }

        public int getIdQB()
        {
            return idQB;
        }

        public String getDescrip()
        {
            return descrip;
        }

        public int getMaddenRating(){
            return maddenRating;
        }

        public String getTeam() { return team; }

        public int getNumber() { return number;}

        public int getBackgroundColor() { return backgroundColor;}

        public int getTextColor() { return textColor;}

        public int getDraftYear() { return draftyear; }

    }
}


