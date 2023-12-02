/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import Model.KhachHang;
import Model.KhachHang02;
import Service.KhachHangService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Serviceimpl.KhachHangService_IMPL;

/**
 *
 * @author Luu Huynh
 */
public class Khach_Hang extends javax.swing.JFrame {

    /**
     * Creates new form Khach_Hang //
     */
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    List<KhachHang> listKhachHang;
    List<KhachHang02> listKhachHang01;

    KhachHangService khsv = new KhachHangService_IMPL();
    private KhachHangService KH;
    private static int currentPage = 1;
    private static int rowFetch = 4;

    public Khach_Hang() {
        initComponents();
        setLocationRelativeTo(null);
        KH = new KhachHangService_IMPL();
        listKhachHang = KH.getall();
//        loadPage(currentPage, rowFetch);    
        showTable(listKhachHang);
        TXT_01.setText("Tổng số khách hàng là : " + listKhachHang.size());

    }

//    private void loadPage(int page, int rowfetch) {
//    DefaultTableModel model = (DefaultTableModel) TB_bang1.getModel();
//    model.setRowCount(0); 
//    int stt = 1;
//    List<KhachHang> list = khsv.loadPaging(page, rowfetch);
//
//    for (KhachHang kh : list) {
//        //model.addRow(kh.toDataRow());
//        Object datarow[] = {kh.getId(),kh.getHo() +" "+ kh.getTendem() + " " + kh.getTen(),kh.getGioitinh() == 0 ? "Nam" : "Nữ" ,kh.getNgaysinh(),kh.getSdt(),kh.getEmail(),kh.getDiemthuong()};
//        model.addRow(datarow);
//    }
//    stt++;
//}
    public void showTable(List<KhachHang> list) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) TB_bang1.getModel();
        defaultTableModel.setRowCount(0);

        for (KhachHang kh : list) {
            Object datarow[] = {
                kh.getId(),
                kh.getHo() + " " + kh.getTendem() + " " + kh.getTen(),
                kh.getGioitinh() == 0 ? "Nam" : "Nữ",
                kh.getNgaysinh(),
                kh.getEmail(),
                kh.getSdt(),
                kh.getDiemthuong()
            };
            defaultTableModel.addRow(datarow);

        }
    }

    public void showTable2(List<KhachHang02> list01) {

        defaultTableModel = (DefaultTableModel) TB_bang02.getModel();
        defaultTableModel.setRowCount(0);
        for (KhachHang02 kh02 : list01) {
            Object dataRow[] = {kh02.getId(), kh02.getHo() + " " + kh02.getTendem() + " " + kh02.getTen(), kh02.getMaHD(), kh02.getNgayTao(), kh02.getDongia(), kh02.getTrangthai() == 0 ? "Đã thanh toán" : "Chưa thanh toán"};
            defaultTableModel.addRow(dataRow);

        }
    }

    public void showTable3(List<KhachHang02> list01) {

        int id = layid();
        defaultTableModel = (DefaultTableModel) TB_bang02.getModel();
        defaultTableModel.setRowCount(0);
        for (KhachHang02 kh02 : KH.GetTKTheoIDKH(id)) {
            Object dataRow[] = {kh02.getId(), kh02.getHo() + " " + kh02.getTendem() + " " + kh02.getTen(), kh02.getMaHD(), kh02.getNgayTao(), kh02.getDongia(), kh02.getTrangthai() == 0 ? "Đã thanh toán" : "Chưa thanh toán"};
            defaultTableModel.addRow(dataRow);

        }
    }

    private KhachHang getData() {
        KhachHang cv = new KhachHang();
        cv.setTen(txt_Ten.getText());
        cv.setTendem(txt_tenDem.getText());
        cv.setHo(txt_Ho.getText());
        int gt;
        if (rd_Nam.isSelected()) {
            gt = 0;
        } else {
            gt = 1;
        }
        cv.setGioitinh(gt);
        cv.setNgaysinh(date_ngaysinh1.getDate());
        cv.setSdt(txt_sdt.getText());
        cv.setEmail(txt_email.getText());

        return cv;
    }

    public int layid() {
        Integer row = TB_bang1.getSelectedRow();
        int id = Integer.parseInt(TB_bang1.getValueAt(row, 0).toString());
        return id;

    }

    public boolean check() {
        String sdt = "(0\\d{9})";
        String mail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern p = Pattern.compile("^[0-9]+$");
        if (txt_Ten.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên!");
            return false;
        }
        if (p.matcher(txt_Ten.getText()).find() == true) {
            JOptionPane.showMessageDialog(this, "Tên của bạn không được nhập số");
            return false;
        }
        if (txt_Ten.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Tên không được quá 30 kí tự");
            return false;
        }

        if (txt_sdt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập SĐT!");
            return false;
        }
        try {
            if (!txt_sdt.getText().matches(sdt)) {
                JOptionPane.showMessageDialog(this, "Số điện thoại của bạn chưa đúng định dạng");
                return false;
            }
        } catch (Exception e) {
        }

        if (KH.kiemtrasdt(txt_sdt.getText()) != null) {
            JOptionPane.showMessageDialog(this, "Số điện thoại của bạn đã tồn tại");
            return false;
        } else if (txt_email.getText().equals("")) {
            return true;
        } else {
            try {

                if (!txt_email.getText().matches(mail)) {
                    JOptionPane.showMessageDialog(this, "Email của bạn chưa đúng định dạng");
                    return false;
                }
                if (KH.kiemtra(txt_email.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Email đã tồn tại");
                    return false;
                }

            } catch (Exception e) {
            }
        }

        return true;

    }

    public boolean check2() {
        Pattern p = Pattern.compile("^[0-9]+$");

        if (txt_Ho.getText() == null & txt_tenDem.getText() == null) {
            return true;
        } else {

            if (p.matcher(txt_Ho.getText()).find() == true) {
                JOptionPane.showMessageDialog(this, "Họ của bạn không được nhập số");
                return false;
            }
            if (txt_Ho.getText().length() > 30) {
                JOptionPane.showMessageDialog(this, "Họ không được quá 30 kí tự");
                return false;
            }
            if (p.matcher(txt_tenDem.getText()).find() == true) {
                JOptionPane.showMessageDialog(this, "Tên đệm của bạn không được nhập số");
                return false;
            }
            if (txt_tenDem.getText().length() > 30) {
                JOptionPane.showMessageDialog(this, "Tên Đệm không được quá 30 kí tự");
                return false;

            }
        }

        return true;
    }

    public boolean check3() {
        String sdt = "(0\\d{9})";
        String mail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern p = Pattern.compile("^[0-9]+$");
        if (txt_Ten.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên!");
            return false;
        }
        if (p.matcher(txt_Ten.getText()).find() == true) {
            JOptionPane.showMessageDialog(this, "Tên của bạn không được nhập số");
            return false;
        }
        if (txt_Ten.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Tên không được quá 30 kí tự");
            return false;
        }
        if (txt_sdt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập SĐT!");
            return false;
        }
        try {
            if (!txt_sdt.getText().matches(sdt)) {
                JOptionPane.showMessageDialog(this, "Số điện thoại của bạn chưa đúng định dạng");
                return false;
            }
        } catch (Exception e) {
        }

        if (txt_email.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Email không được để trống");
            return false;
        } else {
            try {

                if (!txt_email.getText().matches(mail)) {
                    JOptionPane.showMessageDialog(this, "Email của bạn chưa đúng định dạng");
                    return false;
                }

            } catch (Exception e) {
            }
        }

        return true;

    }

    public boolean check4() {
        Pattern p = Pattern.compile("^[0-9]+$");

        if (txt_Ho.getText() == null & txt_tenDem.getText() == null) {
            return true;
        } else {

            if (p.matcher(txt_Ho.getText()).find() == true) {
                JOptionPane.showMessageDialog(this, "Họ của bạn không được nhập số");
                return false;
            }
            if (txt_Ho.getText().length() > 30) {
                JOptionPane.showMessageDialog(this, "Họ không được quá 30 kí tự");
                return false;
            }
            if (p.matcher(txt_tenDem.getText()).find() == true) {
                JOptionPane.showMessageDialog(this, "Tên đệm của bạn không được nhập số");
                return false;
            }
            if (txt_tenDem.getText().length() > 30) {
                JOptionPane.showMessageDialog(this, "Tên Đệm không được quá 30 kí tự");
                return false;

            }
        }

        return true;
    }

    public boolean check5() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date selectedDate = date_ngaysinh1.getDate();

        if (selectedDate == null) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập ngày sinh");
            return false;
        } else {
            if (selectedDate.compareTo(new Date()) > 0) {
                JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ");
                return false;
            }

            return true;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelGradiente1 = new swing.PanelGradiente();
        panelBorder1 = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        txt_Ten = new swing.MyTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_tenDem = new swing.MyTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_Ho = new swing.MyTextField();
        jLabel8 = new javax.swing.JLabel();
        rd_nu = new javax.swing.JRadioButton();
        rd_Nam = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_sdt = new swing.MyTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_email = new swing.MyTextField();
        btn_them = new swing.MyButton();
        Btn_capNhat = new swing.MyButton();
        btn_LamMoi = new swing.MyButton();
        date_ngaysinh1 = new com.toedter.calendar.JDateChooser();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TB_bang1 = new javax.swing.JTable();
        panelBorder3 = new swing.PanelBorder();
        Btn_timKiem1 = new javax.swing.JLabel();
        txt_timKiem01 = new swing.SearchText();
        TXT_01 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TB_bang02 = new javax.swing.JTable();
        btn_LamMoi1 = new swing.MyButton();
        LBL_SOLUONG = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGradiente1.setColorPrimario(new java.awt.Color(204, 255, 255));
        panelGradiente1.setColorSecundario(new java.awt.Color(255, 204, 255));

        panelBorder1.setBackground(new java.awt.Color(204, 204, 255));
        panelBorder1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Tên");
        panelBorder1.add(jLabel1);
        jLabel1.setBounds(90, 10, 210, 20);
        panelBorder1.add(txt_Ten);
        txt_Ten.setBounds(90, 30, 210, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Tên đệm");
        panelBorder1.add(jLabel5);
        jLabel5.setBounds(90, 70, 210, 20);
        panelBorder1.add(txt_tenDem);
        txt_tenDem.setBounds(90, 90, 210, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Họ");
        panelBorder1.add(jLabel6);
        jLabel6.setBounds(90, 130, 210, 20);
        panelBorder1.add(txt_Ho);
        txt_Ho.setBounds(90, 150, 210, 30);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Giới tính");
        panelBorder1.add(jLabel8);
        jLabel8.setBounds(90, 200, 48, 30);

        rd_nu.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(rd_nu);
        rd_nu.setText("Nữ");
        panelBorder1.add(rd_nu);
        rd_nu.setBounds(230, 200, 60, 30);

        rd_Nam.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(rd_Nam);
        rd_Nam.setSelected(true);
        rd_Nam.setText("Nam");
        rd_Nam.setToolTipText("");
        rd_Nam.setDoubleBuffered(true);
        panelBorder1.add(rd_Nam);
        rd_Nam.setBounds(157, 200, 60, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Ngày sinh");
        panelBorder1.add(jLabel2);
        jLabel2.setBounds(390, 10, 210, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Số điện thoại");
        panelBorder1.add(jLabel7);
        jLabel7.setBounds(390, 70, 210, 20);
        panelBorder1.add(txt_sdt);
        txt_sdt.setBounds(390, 90, 210, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("E-mail");
        panelBorder1.add(jLabel9);
        jLabel9.setBounds(390, 130, 210, 20);
        panelBorder1.add(txt_email);
        txt_email.setBounds(390, 150, 210, 30);

        btn_them.setBackground(new java.awt.Color(125, 224, 237));
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_them);
        btn_them.setBounds(670, 30, 120, 40);

        Btn_capNhat.setBackground(new java.awt.Color(125, 224, 237));
        Btn_capNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        Btn_capNhat.setText("Cập nhật");
        Btn_capNhat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_capNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_capNhatActionPerformed(evt);
            }
        });
        panelBorder1.add(Btn_capNhat);
        Btn_capNhat.setBounds(670, 90, 120, 40);

        btn_LamMoi.setBackground(new java.awt.Color(125, 224, 237));
        btn_LamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btn_LamMoi.setText("Làm Mới");
        btn_LamMoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_LamMoi);
        btn_LamMoi.setBounds(670, 150, 120, 40);
        panelBorder1.add(date_ngaysinh1);
        date_ngaysinh1.setBounds(390, 30, 210, 30);

        panelGradiente1.add(panelBorder1);
        panelBorder1.setBounds(10, 0, 990, 260);

        jTabbedPane3.setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        TB_bang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ Và Tên", "Giới Tính", "Ngày Sinh", "SĐT", "Email", "Điểm Thưởng"
            }
        ));
        TB_bang1.setGridColor(new java.awt.Color(255, 255, 255));
        TB_bang1.setRowHeight(25);
        TB_bang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_bang1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TB_bang1);

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));

        Btn_timKiem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_24px.png"))); // NOI18N
        Btn_timKiem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_timKiem1MouseClicked(evt);
            }
        });
        panelBorder3.add(Btn_timKiem1);
        Btn_timKiem1.setBounds(480, 0, 40, 40);

        txt_timKiem01.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timKiem01KeyReleased(evt);
            }
        });
        panelBorder3.add(txt_timKiem01);
        txt_timKiem01.setBounds(20, 0, 450, 40);

        TXT_01.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TXT_01.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TXT_01, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                        .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_01, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Thông Tin Khách Hàng", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        TB_bang02.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ Và Tên", "SĐT", "Mã Hoá Đơn", "Ngày Tạo Hoá Đơn", "Tổng Tiền", "Trạng Thái"
            }
        ));
        TB_bang02.setRowHeight(25);
        jScrollPane4.setViewportView(TB_bang02);

        btn_LamMoi1.setBackground(new java.awt.Color(125, 224, 237));
        btn_LamMoi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btn_LamMoi1.setText("HIển THị");
        btn_LamMoi1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_LamMoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoi1ActionPerformed(evt);
            }
        });

        LBL_SOLUONG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LBL_SOLUONG.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LBL_SOLUONG, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_LamMoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_LamMoi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBL_SOLUONG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Lịch Sử Mua Hàng", jPanel2);

        panelGradiente1.add(jTabbedPane3);
        jTabbedPane3.setBounds(12, 270, 990, 370);

        jButton1.setText("<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelGradiente1.add(jButton1);
        jButton1.setBounds(260, 660, 70, 23);

        jButton2.setText("1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelGradiente1.add(jButton2);
        jButton2.setBounds(370, 660, 75, 23);

        jButton3.setText("2");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelGradiente1.add(jButton3);
        jButton3.setBounds(490, 660, 80, 20);

        jButton4.setText("3");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panelGradiente1.add(jButton4);
        jButton4.setBounds(610, 660, 80, 23);

        jButton5.setText(">");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panelGradiente1.add(jButton5);
        jButton5.setBounds(730, 660, 70, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        if (check() && check2() && check3() && check4() && check5()) {
            JOptionPane.showMessageDialog(this, KH.add(getData()));
            listKhachHang = KH.getall();
            showTable(listKhachHang);
            //loadPage(currentPage, rowFetch);
            TXT_01.setText("Tổng số khách hàng là : " + listKhachHang.size());
            if (KH.add(getData())) {
                JOptionPane.showMessageDialog(this, "Add thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Add thất bại");
            }
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void Btn_capNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_capNhatActionPerformed
        int row = TB_bang1.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "cần chọn khách hàng để cập nhật");
            return;
        }
        if (check3() && check4()) {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật không?") == JOptionPane.YES_OPTION) {
                int id = layid();

                JOptionPane.showMessageDialog(this, KH.update(id, getData()));
                listKhachHang = KH.getall();
                showTable(listKhachHang);
                // loadPage(currentPage, rowFetch);
                TXT_01.setText("Tổng số khách hàng là : " + listKhachHang.size());
                if (KH.update(id, getData())) {
                    JOptionPane.showMessageDialog(this, "Update thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Update thất bại");
                }
            }
        }
    }//GEN-LAST:event_Btn_capNhatActionPerformed

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        txt_Ten.setText("");
        txt_tenDem.setText("");
        txt_Ho.setText("");
        date_ngaysinh1.setCalendar(null);
        txt_sdt.setText("");
        txt_email.setText("");
    }//GEN-LAST:event_btn_LamMoiActionPerformed

    private void TB_bang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_bang1MouseClicked

        int id = layid();
        showTable3(listKhachHang01);

        listKhachHang01 = KH.GetTKTheoIDKH(id);
        LBL_SOLUONG.setText("Tổng số hoá đơn là : " + KH.GetTKTheoIDKH(id).size());

        int row = TB_bang1.getSelectedRow();
        KhachHang kh = listKhachHang.get(row);
        txt_Ten.setText(kh.getTen());
        txt_tenDem.setText(kh.getTendem());
        txt_Ho.setText(kh.getHo());
        String gt = (TB_bang1.getValueAt(row, 2).toString());
        if (gt == "Nam") {
            rd_Nam.setSelected(true);
        } else {
            rd_nu.setSelected(true);
        }
        date_ngaysinh1.setDate((Date) TB_bang1.getValueAt(row, 3));
        txt_sdt.setText(kh.getSdt());
        txt_email.setText(kh.getEmail());


    }//GEN-LAST:event_TB_bang1MouseClicked

    private void Btn_timKiem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_timKiem1MouseClicked

    }//GEN-LAST:event_Btn_timKiem1MouseClicked

    private void txt_timKiem01KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiem01KeyReleased
        defaultTableModel = (DefaultTableModel) TB_bang1.getModel();
        defaultTableModel.setRowCount(0);
        for (KhachHang kh : KH.GetTK(txt_timKiem01.getText())) {
            Object datarow[] = {kh.getId(), kh.getHo() + " " + kh.getTendem() + " " + kh.getTen(), kh.getGioitinh() == 0 ? "Nam" : "Nữ", kh.getNgaysinh(), kh.getSdt(), kh.getEmail(), kh.getDiemthuong()};
            defaultTableModel.addRow(datarow);
        }
    }//GEN-LAST:event_txt_timKiem01KeyReleased

    private void btn_LamMoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoi1ActionPerformed
        listKhachHang01 = KH.getall02();
        showTable2(listKhachHang01);
        LBL_SOLUONG.setText("Tổng số hoá đơn là : " + listKhachHang01.size());
    }//GEN-LAST:event_btn_LamMoi1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
//        currentPage = 3;
//        loadPage(currentPage, rowFetch);


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        currentPage = 1;
//        loadPage(currentPage, rowFetch);


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:\
//        if (currentPage == 1) {
//            JOptionPane.showMessageDialog(this, "Bạn đã về trang đầu");
//        } else {
//            currentPage--;
//            loadPage(currentPage, rowFetch);
//        }        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
//        if (currentPage == 3) {
//            JOptionPane.showMessageDialog(this, "Bạn đã về trang cuối");
//        } else {
//            currentPage++;
//            loadPage(currentPage, rowFetch);
//        }
//        

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
//        currentPage = 2;
//        loadPage(currentPage, rowFetch);

    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Khach_Hang().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton Btn_capNhat;
    private javax.swing.JLabel Btn_timKiem1;
    private javax.swing.JLabel LBL_SOLUONG;
    private javax.swing.JTable TB_bang02;
    private javax.swing.JTable TB_bang1;
    private javax.swing.JLabel TXT_01;
    private swing.MyButton btn_LamMoi;
    private swing.MyButton btn_LamMoi1;
    private swing.MyButton btn_them;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser date_ngaysinh1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane3;
    private swing.PanelBorder panelBorder1;
    private swing.PanelBorder panelBorder3;
    private swing.PanelGradiente panelGradiente1;
    private javax.swing.JRadioButton rd_Nam;
    private javax.swing.JRadioButton rd_nu;
    private swing.MyTextField txt_Ho;
    private swing.MyTextField txt_Ten;
    private swing.MyTextField txt_email;
    private swing.MyTextField txt_sdt;
    private swing.MyTextField txt_tenDem;
    private swing.SearchText txt_timKiem01;
    // End of variables declaration//GEN-END:variables
}
