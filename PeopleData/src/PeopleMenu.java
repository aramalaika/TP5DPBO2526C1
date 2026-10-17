import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleMenu {
    private JPanel mainPanel;
    private JTextField idField;
    private JTextField nameField;
    private JTextField tahuField;
    private JComboBox kategoriComboBox;
    private JTextField emailField;
    private JButton tambahButton;
    private JButton updateButton;
    private JButton hapusButton;
    private JButton clearButton;
    private JTable peopleTable;
    private JLabel judulLabel;

    public PeopleMenu() {
        kategoriComboBox.removeAllItems();
        kategoriComboBox.addItem("Full-time");
        kategoriComboBox.addItem("Part-time");
        kategoriComboBox.addItem("Contract");
        kategoriComboBox.addItem("Internship");

        setTable();

        tambahButton.addActionListener(e -> insertData());
        updateButton.addActionListener(e -> updateData());
        hapusButton.addActionListener(e -> deleteData());
        clearButton.addActionListener(e -> clearForm());

        peopleTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = peopleTable.getSelectedRow();

                if (row != -1) {
                    idField.setText(peopleTable.getValueAt(row, 0).toString());
                    nameField.setText(peopleTable.getValueAt(row, 1).toString());
                    tahuField.setText(peopleTable.getValueAt(row, 2).toString());
                    kategoriComboBox.setSelectedItem(
                            peopleTable.getValueAt(row, 3).toString()
                    );
                    emailField.setText(peopleTable.getValueAt(row, 4).toString());

                    idField.setEditable(false);
                }
            }
        });

        // Font
        Font poppins = new Font("Poppins", Font.PLAIN, 14);
        Font poppinsBold = new Font("Poppins", Font.BOLD, 14);
        Font poppinsTitle = new Font("Poppins", Font.BOLD, 24);

        judulLabel.setFont(poppinsTitle);
        judulLabel.setForeground(new Color(80, 50, 60));

        idField.setFont(poppins);
        nameField.setFont(poppins);
        tahuField.setFont(poppins);
        emailField.setFont(poppins);
        kategoriComboBox.setFont(poppins);

        tambahButton.setFont(poppinsBold);
        updateButton.setFont(poppinsBold);
        hapusButton.setFont(poppinsBold);
        clearButton.setFont(poppinsBold);

        peopleTable.setFont(poppins);
        peopleTable.getTableHeader().setFont(poppinsBold);

        // Warna tampilan
        mainPanel.setBackground(new Color(255, 247, 240));

        tambahButton.setBackground(new Color(248, 200, 220));
        tambahButton.setForeground(new Color(80, 50, 60));
        tambahButton.setOpaque(true);
        tambahButton.setBorderPainted(false);

        updateButton.setBackground(new Color(249, 231, 162));
        updateButton.setForeground(new Color(80, 65, 40));
        updateButton.setOpaque(true);
        updateButton.setBorderPainted(false);

        hapusButton.setBackground(new Color(236, 165, 194));
        hapusButton.setForeground(new Color(80, 40, 55));
        hapusButton.setOpaque(true);
        hapusButton.setBorderPainted(false);

        peopleTable.setBackground(new Color(255, 247, 240));
        peopleTable.setForeground(new Color(80, 50, 60));
        peopleTable.getTableHeader().setBackground(new Color(249, 231, 162));
        peopleTable.getTableHeader().setForeground(new Color(80, 65, 40));
    }

    // Koneksi database
    private Connection getConnection() {
        Database db = new Database();
        Connection conn = db.getConnection();

        if (conn == null) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "Koneksi gagal! Pastikan MySQL menyala."
            );
        }

        return conn;
    }

    // Menampilkan data dari database
    public void setTable() {
        String[] columnNames = {
                "ID", "Nama", "Tahun Lahir", "Kategori", "Email"
        };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String sql = "SELECT id, nama, thn_lahir, kategori, email FROM person";

        try (Connection conn = getConnection()) {
            if (conn == null) {
                return;
            }

            try (PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Object[] data = {
                            rs.getString("id"),
                            rs.getString("nama"),
                            rs.getInt("thn_lahir"),
                            rs.getString("kategori"),
                            rs.getString("email")
                    };

                    model.addRow(data);
                }
            }

            peopleTable.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "Gagal mengambil data: " + e.getMessage()
            );
        }
    }

    // Menambahkan data
    public void insertData() {
        String id = idField.getText().trim();
        String nama = nameField.getText().trim();
        String tahunText = tahuField.getText().trim();
        String email = emailField.getText().trim();

        if (id.isEmpty() || nama.isEmpty()
                || tahunText.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(
                    mainPanel, "Semua input wajib diisi!"
            );
            return;
        }

        int tahun;

        try {
            tahun = Integer.parseInt(tahunText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    mainPanel, "Tahun lahir harus berupa angka!"
            );
            return;
        }

        String kategori = kategoriComboBox.getSelectedItem().toString();

        String sql = "INSERT INTO person "
                + "(id, nama, thn_lahir, kategori, email) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection()) {
            if (conn == null) {
                return;
            }

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, id);
                ps.setString(2, nama);
                ps.setInt(3, tahun);
                ps.setString(4, kategori);
                ps.setString(5, email);

                ps.executeUpdate();
            }

            JOptionPane.showMessageDialog(
                    mainPanel, "Data berhasil ditambahkan!"
            );

            setTable();
            clearForm();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "Gagal menambahkan data: " + e.getMessage()
            );
        }
    }

    // Mengubah data
    public void updateData() {
        int row = peopleTable.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(
                    mainPanel, "Pilih data yang ingin diubah!"
            );
            return;
        }

        String id = peopleTable.getValueAt(row, 0).toString();
        String nama = nameField.getText().trim();
        String tahunText = tahuField.getText().trim();
        String kategori = kategoriComboBox.getSelectedItem().toString();
        String email = emailField.getText().trim();

        if (nama.isEmpty() || tahunText.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(
                    mainPanel, "Semua input wajib diisi!"
            );
            return;
        }

        int tahun;

        try {
            tahun = Integer.parseInt(tahunText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    mainPanel, "Tahun lahir harus berupa angka!"
            );
            return;
        }

        String sql = "UPDATE person SET nama = ?, thn_lahir = ?, "
                + "kategori = ?, email = ? WHERE id = ?";

        try (Connection conn = getConnection()) {
            if (conn == null) {
                return;
            }

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, nama);
                ps.setInt(2, tahun);
                ps.setString(3, kategori);
                ps.setString(4, email);
                ps.setString(5, id);

                ps.executeUpdate();
            }

            JOptionPane.showMessageDialog(
                    mainPanel, "Data berhasil diubah!"
            );

            setTable();
            clearForm();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "Gagal mengubah data: " + e.getMessage()
            );
        }
    }

    // Menghapus data
    public void deleteData() {
        int row = peopleTable.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(
                    mainPanel, "Pilih data yang ingin dihapus!"
            );
            return;
        }

        String id = peopleTable.getValueAt(row, 0).toString();

        int confirm = JOptionPane.showConfirmDialog(
                mainPanel,
                "Yakin ingin menghapus data ini?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        String sql = "DELETE FROM person WHERE id = ?";

        try (Connection conn = getConnection()) {
            if (conn == null) {
                return;
            }

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, id);
                ps.executeUpdate();
            }

            JOptionPane.showMessageDialog(
                    mainPanel, "Data berhasil dihapus!"
            );

            setTable();
            clearForm();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "Gagal menghapus data: " + e.getMessage()
            );
        }
    }

    // Membersihkan input
    public void clearForm() {
        idField.setText("");
        nameField.setText("");
        tahuField.setText("");
        emailField.setText("");

        kategoriComboBox.setSelectedIndex(0);

        idField.setEditable(true);
        peopleTable.clearSelection();
    }

    // Menjalankan aplikasi
    public static void main(String[] args) {
        JFrame frame = new JFrame("PeopleData");
        PeopleMenu peopleMenu = new PeopleMenu();

        frame.setContentPane(peopleMenu.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
