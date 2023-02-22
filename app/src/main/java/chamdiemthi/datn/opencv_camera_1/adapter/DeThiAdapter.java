package chamdiemthi.datn.opencv_camera_1.adapter;

import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rantea.opencv_camera_1.R;

import chamdiemthi.datn.opencv_camera_1.MaDeActivity;
import chamdiemthi.datn.opencv_camera_1.app.Utils;
import chamdiemthi.datn.opencv_camera_1.models.BaiThi;
import chamdiemthi.datn.opencv_camera_1.models.DeThi;


public class DeThiAdapter extends RecyclerView.Adapter<DeThiAdapter.BTVH> implements View.OnClickListener {

    int iBT;
    BaiThi baiThi;

    public DeThiAdapter(int iBT) {
        this.iBT = iBT;
        baiThi = Utils.dsBaiThi.get(iBT);
    }

    @Override
    public BTVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BTVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_de_thi, parent, false));
    }

    @Override
    public void onBindViewHolder(BTVH holder, int position) {
        DeThi deThi = baiThi.dsDeThi.get(position);
        holder.ma.setText("" + deThi.maDeThi);
        holder.item.setId(position);
        holder.item.setOnClickListener(this);
        holder.imageRemoveDeThi.setOnClickListener(v -> {
            baiThi.dsDeThi.remove(deThi);
            notifyDataSetChanged();
        });
    }

    @Override
    public void onClick(View v) {
        int position = v.getId();
        v.getContext().startActivity(
                new Intent(v.getContext(), MaDeActivity.class)
                        .putExtra(Utils.ARG_P_BAI_THI, iBT)
                        .putExtra(Utils.ARG_P_DE_THI, position)
        );
    }

    @Override
    public int getItemCount() {
        return baiThi.dsDeThi.size();
    }


    public class BTVH extends RecyclerView.ViewHolder {

        View item;
        TextView ma;
        ImageView imageRemoveDeThi;

        public BTVH(View itemView) {
            super(itemView);
            ma = itemView.findViewById(R.id.tv_ma_de);
            item = itemView.findViewById(R.id.item_bai_thi);
            imageRemoveDeThi = itemView.findViewById(R.id.image_removeDeThi);
        }
    }
}
