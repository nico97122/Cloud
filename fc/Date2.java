/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.fc;

/**
 *
 * @author nicol
 */
import java.util.Date;
public class Date2 {
    private int année;
    private int mois;
    private int jour;
    private int heure;
    private int minute;
     public Date2( int année ,int mois,int jour)
    {
     this.année=année;
    this.mois=mois;
    this.jour=jour;
   this.heure=0;
   this.minute=0;
    
}
    public Date2( int année ,int mois,int jour, int heure,int minute)
    {
     this.année=année;
    this.mois=mois;
    this.jour=jour;
    this.heure=heure;
    this.minute=minute;
    
}
    public Date2 comparerDate(Date2 d1, Date2 d2){  // renvoie la date la plus récente
        Date da1= new Date(d1.modifFormat(d1)[0],d1.modifFormat(d1)[1],d1.modifFormat(d1)[2],d1.modifFormat(d1)[3],d1.modifFormat(d1)[4]);
        Date da2=new Date(d2.modifFormat(d2)[0],d2.modifFormat(d2)[1],d2.modifFormat(d2)[2],d2.modifFormat(d1)[3],d2.modifFormat(d2)[4]);
      int  compare=da1.compareTo(da2);
      if (compare<0){
          return d2;
          }
      else return d1;
      
    }
    
    public int[] modifFormat(Date2 date){ //renvoie la date dans un tableau de 5 éléments
       int[] d=new int[5];
       d[0]=date.année;
       d[1]=date.mois;
       d[2]=date.jour;
       d[3]=date.heure;
       d[4]=date.minute;
        return d;
    }
    @Override
    public String toString(){ //renvoie la date sous forme de texte
        return "le "+this.jour+" "+this.mois+" "+this.année+" à "+this.heure+":"+this.minute;
    }
}
