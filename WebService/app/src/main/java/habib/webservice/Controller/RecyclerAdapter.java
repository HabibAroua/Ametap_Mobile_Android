package habib.webservice.Controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import habib.webservice.Model.Activite;
import habib.webservice.R;

/**
 * Created by lenovo on 05/04/2017.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>
{
    ArrayList<Activite> arrayList=new ArrayList<>();

    public RecyclerAdapter(ArrayList<Activite> arrayList)
    {
        this.arrayList=arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.id.setText(arrayList.get(position).getId());
        holder.nom_activite.setText(arrayList.get(position).getNom_activite());
        holder.date_debut.setText(arrayList.get((position)).getDate_debut());
        holder.date_fin.setText(arrayList.get(position).getDate_fin());
        holder.prix_unitaire.setText(arrayList.get(position).getPrix_unitaire()+" DT");
        holder.nom_organisateur.setText(arrayList.get(position).getOrganisateur());
    }

    @Override
    public int getItemCount()
    {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView id,nom_activite,date_debut,date_fin,prix_unitaire,nom_organisateur;
        public MyViewHolder(View itemView)
        {
            super(itemView);
            id=(TextView)itemView.findViewById(R.id.viewID);
            nom_activite=(TextView)itemView.findViewById(R.id.viewNom_Activite);
            date_debut=(TextView)itemView.findViewById(R.id.viewDateDebut);
            date_fin=(TextView)itemView.findViewById(R.id.viewDateFin);
            prix_unitaire=(TextView)itemView.findViewById(R.id.viewPrixUnitaire);
            nom_organisateur=(TextView)itemView.findViewById(R.id.viewNomOrganisateur);
        }
    }
}
