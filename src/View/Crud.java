package View;

import Dao.DaoCliente;
import Dao.DaoItemPedido;
import Dao.DaoPedido;
import Dao.DaoProduto;
import java.awt.Color;
import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import services.ServicosCrud;
import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabri
 */
public class Crud extends javax.swing.JFrame {
    List<Cliente> clientes;
    List<Produto> produtos;
    List<Pedido> pedidos;
    List<ItemPedido> itemDePedido;
    List<ItemPedido> itemPedidoCarrinho;
    List<Produto> pro;
    List<Cliente> cli;
    List<Pedido> ped;
    
    DaoCliente daoCliente;
    DaoProduto daoProduto;
    DaoPedido daoPedido;
    DaoItemPedido daoItemPedido;

    ServicosCrud servicos = new ServicosCrud();
   
            
            public void criarTabela(){
                clientes = daoCliente.buscarTodos();
                DefaultTableModel model = (DefaultTableModel) tableClientes.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[4];
                for(int i = 0; i < clientes.size(); i++){
                    dadosLinha[0] = String.valueOf(clientes.get(i).getCpf());
                    dadosLinha[1] = clientes.get(i).getNome();
                    dadosLinha[2] = String.valueOf(clientes.get(i).getDataNascimento());
                    dadosLinha[3] = String.valueOf(clientes.get(i).getContato());
                    model.addRow(dadosLinha);
                }
            }
            public void criarTabelaPesquisado(){
                DefaultTableModel model = (DefaultTableModel) tableClientes.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[4];
                for(int i = 0; i < cli.size(); i++){
                    dadosLinha[0] = String.valueOf(cli.get(i).getCpf());
                    dadosLinha[1] = cli.get(i).getNome();
                    dadosLinha[2] = String.valueOf(cli.get(i).getDataNascimento());
                    dadosLinha[3] = String.valueOf(cli.get(i).getContato());
                    model.addRow(dadosLinha);
                }
            }
            
            public void criarTabelaProduto(){
                produtos = daoProduto.buscarTodos();
                DefaultTableModel model = (DefaultTableModel) tableProdutos.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[3];
                for(int i = 0; i < produtos.size(); i++){
                    dadosLinha[0] = String.valueOf(produtos.get(i).getCodigo());
                    dadosLinha[1] = produtos.get(i).getNome();
                    dadosLinha[2] = String.valueOf(produtos.get(i).getPreco());
                    model.addRow(dadosLinha);
                }
            }
            public void criarTabelaProdutoPesquisado(){
                DefaultTableModel model = (DefaultTableModel) tableProdutos.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[3];
                for(int i = 0; i < pro.size(); i++){
                    dadosLinha[0] = String.valueOf(pro.get(i).getCodigo());
                    dadosLinha[1] = pro.get(i).getNome();
                    dadosLinha[2] = String.valueOf(pro.get(i).getPreco());
                    model.addRow(dadosLinha);
                }
            }
            
            public void criarTabelaPedidos(){
                pedidos = daoPedido.buscarTodos();
                DefaultTableModel model = (DefaultTableModel) tabelaPedidos.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[4];
                for(int i = 0; i < pedidos.size(); i++){
                    dadosLinha[0] = String.valueOf(pedidos.get(i).getCodigo());
                    dadosLinha[1] = pedidos.get(i).getData();
                    dadosLinha[2] = String.valueOf(pedidos.get(i).getCliente().getCpf());
                    dadosLinha[3] = pedidos.get(i).getCliente().getNome();
                    model.addRow(dadosLinha);
                }
            }
            public void criarTabelaPedidosPesquisado(){
                DefaultTableModel model = (DefaultTableModel) tabelaPedidos.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[4];
                for(int i = 0; i < ped.size(); i++){
                    dadosLinha[0] = String.valueOf(ped.get(i).getCodigo());
                    dadosLinha[1] = ped.get(i).getData();
                    dadosLinha[2] = String.valueOf(ped.get(i).getCliente().getCpf());
                    dadosLinha[3] = ped.get(i).getCliente().getNome();
                    model.addRow(dadosLinha);
                }
            }            

            public void criarTabelaPedidoProdutos(){
                DefaultTableModel model = (DefaultTableModel) tabelaPedidoProduto.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[5];
                for(int i = 0; i < itemDePedido.size(); i++){
                    servicos.calcularSubtotal(itemDePedido.get(i));
                    dadosLinha[0] = String.valueOf(itemDePedido.get(i).getQuantidade());
                    dadosLinha[1] = itemDePedido.get(i).getProduto().getNome();
                    dadosLinha[2] = String.valueOf(itemDePedido.get(i).getProduto().getPreco());
                    dadosLinha[3] = String.valueOf(itemDePedido.get(i).getPorcentagemDesconto());
                    dadosLinha[4] = String.valueOf(itemDePedido.get(i).getProduto().getPrecoDesconto());
                    model.addRow(dadosLinha);
                }
            }
            
            public void criarTabelaCarrinho(){
                itemPedidoCarrinho = daoItemPedido.buscarTodos();
                DefaultTableModel model = (DefaultTableModel) tabelaCarrinho.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[6];
                for(int i = 0; i < itemPedidoCarrinho.size(); i++){
                    dadosLinha[0] = String.valueOf(itemPedidoCarrinho.get(i).getQuantidade());
                    dadosLinha[1] = String.valueOf(itemPedidoCarrinho.get(i).getProduto().getCodigo());
                    dadosLinha[2] = itemPedidoCarrinho.get(i).getProduto().getNome();
                    dadosLinha[3] = String.valueOf(itemPedidoCarrinho.get(i).getProduto().getPreco());
                    dadosLinha[4] = String.valueOf(itemPedidoCarrinho.get(i).getPorcentagemDesconto());
                    dadosLinha[5] = String.valueOf(itemPedidoCarrinho.get(i).getPedidoID());
                    model.addRow(dadosLinha);
                }
            }
              
            
    public Crud(){
        initComponents();
        daoCliente = new DaoCliente();
        daoProduto = new DaoProduto();
        daoPedido = new DaoPedido();
        daoItemPedido = new DaoItemPedido();
        
        clientes = new ArrayList<>();
        produtos = new ArrayList<>();
        pedidos = new ArrayList<>();
        itemDePedido = new ArrayList<>();
        itemPedidoCarrinho = new ArrayList<>();
        pro = new ArrayList<>();
        cli = new ArrayList<>();
        ped = new ArrayList<>();

        clientes = daoCliente.buscarTodos();
        produtos = daoProduto.buscarTodos();
        pedidos = daoPedido.buscarTodos();
        itemPedidoCarrinho = daoItemPedido.buscarTodos();

    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        paneCliente = new javax.swing.JTabbedPane();
        Cliente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        txtDataNascimento = new javax.swing.JTextField();
        txtContato = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cadastar = new javax.swing.JButton();
        Remover = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtNomeCliente = new javax.swing.JTextField();
        pesquisarCliente = new javax.swing.JButton();
        produto = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPrecoProduto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCodigoProduto = new javax.swing.JTextField();
        cadastarProduto = new javax.swing.JButton();
        RemoverProduto = new javax.swing.JButton();
        alterarProduto = new javax.swing.JButton();
        atualizarProduto = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableProdutos = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        pesquisarProduto = new javax.swing.JButton();
        pedido = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtNumeroPedido = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cadastarPedido = new javax.swing.JButton();
        RemoverPedido = new javax.swing.JButton();
        AtualizarPedido = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txtCodigoClientePedido = new javax.swing.JTextField();
        txtDataPedido = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaPedidos = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaPedidoProduto = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        valorTotalPedido = new javax.swing.JLabel();
        txtCPFpesquisa = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtCodigoProdutoCarrinho = new javax.swing.JTextField();
        cadastarCarrinho = new javax.swing.JButton();
        txtQuantidadeCarrinho = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtNumeroPedidoCarrinho = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtDescontoCarrinho = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaCarrinho = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        excluirItemPedido = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("CPF:");

        jLabel3.setText("Data nascimento:");

        jLabel4.setText("Contato: ");

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel5.setText("Cadastro de clientes");

        cadastar.setText("Cadastar");
        cadastar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastarActionPerformed(evt);
            }
        });

        Remover.setText("Remover");
        Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverActionPerformed(evt);
            }
        });

        alterar.setText("Alterar");
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CPF", "Nome", "Data nascimento", "Contato"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableClientes);

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel6.setText("Lista de clientes");

        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Liberar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pesquisarCliente.setText("Pesquisar por nome");
        pesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ClienteLayout = new javax.swing.GroupLayout(Cliente);
        Cliente.setLayout(ClienteLayout);
        ClienteLayout.setHorizontalGroup(
            ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClienteLayout.createSequentialGroup()
                .addGroup(ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ClienteLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(404, 404, 404)
                        .addComponent(cadastar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ClienteLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ClienteLayout.createSequentialGroup()
                                .addGroup(ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ClienteLayout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ClienteLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(159, 159, 159)
                                .addGroup(ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ClienteLayout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ClienteLayout.createSequentialGroup()
                                        .addGroup(ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(ClienteLayout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                                        .addGroup(ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(alterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Remover, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))))))
                            .addGroup(ClienteLayout.createSequentialGroup()
                                .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pesquisarCliente)
                                .addGap(205, 205, 205)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))))
                .addGap(79, 79, 79))
        );
        ClienteLayout.setVerticalGroup(
            ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClienteLayout.createSequentialGroup()
                .addGroup(ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ClienteLayout.createSequentialGroup()
                        .addGroup(ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ClienteLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cadastar)
                                    .addComponent(jButton2)))
                            .addGroup(ClienteLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ClienteLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(Remover)))
                .addGap(18, 18, 18)
                .addComponent(alterar)
                .addGap(4, 4, 4)
                .addGroup(ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClienteLayout.createSequentialGroup()
                        .addGroup(ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClienteLayout.createSequentialGroup()
                        .addGroup(ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pesquisarCliente))
                        .addGap(4, 4, 4)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        paneCliente.addTab("Cliente", Cliente);

        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel7.setText("Cadastro de Produtos");

        jLabel8.setText("Nome:");

        jLabel9.setText("Preço:");

        jLabel10.setText("Código:");

        cadastarProduto.setText("Cadastar");
        cadastarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastarProdutoActionPerformed(evt);
            }
        });

        RemoverProduto.setText("Remover");
        RemoverProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverProdutoActionPerformed(evt);
            }
        });

        alterarProduto.setText("Alterar");
        alterarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarProdutoActionPerformed(evt);
            }
        });

        atualizarProduto.setText("Atualizar");
        atualizarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarProdutoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel12.setText("Lista de Produtos");

        tableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProdutosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableProdutos);

        jButton3.setText("Liberar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        pesquisarProduto.setText("Pesquise por nome");
        pesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout produtoLayout = new javax.swing.GroupLayout(produto);
        produto.setLayout(produtoLayout);
        produtoLayout.setHorizontalGroup(
            produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, produtoLayout.createSequentialGroup()
                .addGroup(produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, produtoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(366, 366, 366)
                        .addComponent(cadastarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, produtoLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(produtoLayout.createSequentialGroup()
                                .addGroup(produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, produtoLayout.createSequentialGroup()
                                        .addGroup(produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton3)
                                            .addGroup(produtoLayout.createSequentialGroup()
                                                .addGroup(produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(produtoLayout.createSequentialGroup()
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(produtoLayout.createSequentialGroup()
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtPrecoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(159, 159, 159)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE))
                                    .addGroup(produtoLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(276, 276, 276)))
                                .addGroup(produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(atualizarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(alterarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(RemoverProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))))
                            .addComponent(jScrollPane3))))
                .addGap(79, 79, 79))
        );
        produtoLayout.setVerticalGroup(
            produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(produtoLayout.createSequentialGroup()
                .addGroup(produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(produtoLayout.createSequentialGroup()
                        .addGroup(produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(produtoLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cadastarProduto)
                                    .addComponent(jButton3)))
                            .addGroup(produtoLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(produtoLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(RemoverProduto)))
                .addGap(18, 18, 18)
                .addComponent(alterarProduto)
                .addGap(4, 4, 4)
                .addGroup(produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPrecoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atualizarProduto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pesquisarProduto)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        paneCliente.addTab("Produto", produto);

        jLabel17.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel17.setText("Novo Pedido");

        jLabel18.setText("Código do pedido");

        jLabel19.setText("CPF cliente:");

        cadastarPedido.setText("Cadastar");
        cadastarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastarPedidoActionPerformed(evt);
            }
        });

        RemoverPedido.setText("Remover");
        RemoverPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverPedidoActionPerformed(evt);
            }
        });

        AtualizarPedido.setText("Atualizar");
        AtualizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarPedidoActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel22.setText("Produtos");

        jLabel20.setText("Data:");

        tabelaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Número do Pedido", "Data do Pedido", "CPF Cliente", "Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPedidosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelaPedidos);

        tabelaPedidoProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Quantidade", "Produto", "Valor", "Porcentagem desconto", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tabelaPedidoProduto);

        jLabel23.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel23.setText("Pedidos");

        jLabel27.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel27.setText("Total do pedido: ");

        valorTotalPedido.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        valorTotalPedido.setText("valor");

        jButton5.setText("Pesquisar por CPF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pedidoLayout = new javax.swing.GroupLayout(pedido);
        pedido.setLayout(pedidoLayout);
        pedidoLayout.setHorizontalGroup(
            pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pedidoLayout.createSequentialGroup()
                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addGap(526, 526, 526)
                        .addComponent(jLabel17))
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtNumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDataPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(cadastarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addGap(970, 970, 970)
                        .addComponent(RemoverPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtCodigoClientePedido, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jLabel23)
                        .addGap(499, 499, 499)
                        .addComponent(jLabel22))
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addGap(490, 490, 490)
                        .addComponent(jLabel27)
                        .addGap(3, 3, 3)
                        .addComponent(valorTotalPedido))
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pedidoLayout.createSequentialGroup()
                                .addComponent(txtCPFpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AtualizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(114, 114, 114))
        );
        pedidoLayout.setVerticalGroup(
            pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pedidoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel18))
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(txtNumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel20))
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(txtDataPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cadastarPedido))
                .addGap(7, 7, 7)
                .addComponent(RemoverPedido)
                .addGap(51, 51, 51)
                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel19))
                    .addComponent(txtCodigoClientePedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(txtCPFpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AtualizarPedido))
                .addGap(8, 8, 8)
                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(valorTotalPedido)))
        );

        paneCliente.addTab("Pedido", pedido);

        jLabel21.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel21.setText("Items de pedido");

        jLabel24.setText("Número pedido:");

        cadastarCarrinho.setText("Lançar Item");
        cadastarCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastarCarrinhoActionPerformed(evt);
            }
        });

        jLabel25.setText("Quantidade: ");

        jLabel26.setText("Código Produto:");

        jLabel28.setText("Desconto: ");

        tabelaCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Quantidade", "Código produto", "Produto", "Preço", "Porcentagem de Desconto", "Pedido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCarrinhoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelaCarrinho);

        jButton4.setText("Atualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        excluirItemPedido.setText("Excluir os item do pedido");
        excluirItemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirItemPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(451, 451, 451)
                        .addComponent(cadastarCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigoProdutoCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNumeroPedidoCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(140, 140, 140)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtQuantidadeCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDescontoCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(488, 488, 488)
                        .addComponent(excluirItemPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(417, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(484, 484, 484)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(118, 694, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(txtDescontoCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(txtNumeroPedidoCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoProdutoCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25)
                    .addComponent(txtQuantidadeCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(cadastarCarrinho))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(excluirItemPedido)
                .addContainerGap(199, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(614, Short.MAX_VALUE)))
        );

        paneCliente.addTab("Carrinho", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(paneCliente)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastarActionPerformed
        int cpf = Integer.parseInt(txtCPF.getText());
        String nome = txtNome.getText();
        String dataNascimento = txtDataNascimento.getText();
        String contato = txtContato.getText();
        
        Cliente cliente = new Cliente(cpf, nome, dataNascimento, contato);
        int resultado = daoCliente.gravar(cliente);
        
        if(resultado == 1){
            JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!");
        }else {
            JOptionPane.showMessageDialog(this, "Ops! algo deu errado");
        }
        
        
        txtCPF.setText("");
        txtNome.setText("");
        txtDataNascimento.setText("");
        txtContato.setText("");
        criarTabela();
    }//GEN-LAST:event_cadastarActionPerformed

    private void RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverActionPerformed
        int cpf = Integer.parseInt(txtCPF.getText());
        String nome = txtNome.getText();
        String dataNascimento = txtDataNascimento.getText();
        String contato = txtContato.getText();
        
        Cliente cliente = new Cliente(cpf, nome, dataNascimento, contato);
        
        int resultado = daoCliente.excluir(cliente);
        
        if(resultado == 1){
            JOptionPane.showMessageDialog(this, "Removido com sucesso!");
        }else {
            JOptionPane.showMessageDialog(this, "Ops! algo deu errado");
        }
        
        criarTabela();
    }//GEN-LAST:event_RemoverActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        criarTabela();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cadastarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastarProdutoActionPerformed
        int codigo = Integer.parseInt(txtCodigoProduto.getText());
        String nome = txtNomeProduto.getText();
        double preco = Double.parseDouble(txtPrecoProduto.getText());
        Produto pro = new Produto(codigo, nome, preco);
        int resultado = daoProduto.gravar(pro);
        
        if(resultado == 1){
            JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!");
        }else {
            JOptionPane.showMessageDialog(this, "Ops! algo deu errado");
        }

        txtCodigoProduto.setText("");
        txtNomeProduto.setText("");
        txtPrecoProduto.setText("");
        criarTabelaProduto();

    }//GEN-LAST:event_cadastarProdutoActionPerformed

    private void RemoverProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverProdutoActionPerformed
        int codigo = Integer.parseInt(txtCodigoProduto.getText());
        String nome = txtNomeProduto.getText();
        double preco = Double.parseDouble(txtPrecoProduto.getText());
        
        Produto pro = new Produto(codigo, nome, preco);
        int resultado = daoProduto.excluir(pro);
        
        if(resultado == 1){
            JOptionPane.showMessageDialog(this, "Removido com sucesso!");
        }else {
            JOptionPane.showMessageDialog(this, "Ops! algo deu errado");
        }
        
        txtCodigoProduto.setText("");
        txtNomeProduto.setText("");
        txtPrecoProduto.setText("");
        criarTabelaProduto();
    }//GEN-LAST:event_RemoverProdutoActionPerformed

    private void atualizarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarProdutoActionPerformed
        criarTabelaProduto();
    }//GEN-LAST:event_atualizarProdutoActionPerformed

    private void cadastarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastarPedidoActionPerformed
        int codigoPedido = Integer.parseInt(txtNumeroPedido.getText());
        int codigoCliente = Integer.parseInt(txtCodigoClientePedido.getText());
        String data = txtDataPedido.getText();
        
        for(int i = 0; i < clientes.size(); i++){
            if(codigoCliente == clientes.get(i).getCpf()){
                Pedido ped = new Pedido(codigoPedido, clientes.get(i), data);
                int resultado = daoPedido.gravar(ped);
                
                if(resultado == 1){
                    JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!");
                    i = clientes.size();
                    break;
                }else {
                    JOptionPane.showMessageDialog(this, "Ops! algo deu errado");
                }
                
                txtCodigoClientePedido.setText("");
                txtNumeroPedido.setText("");
                txtDataPedido.setText("");
            }else{
                JOptionPane.showMessageDialog(this, "Algo está errado! confira e tente novamente");
            }
        }
        criarTabelaPedidos();
        
    }//GEN-LAST:event_cadastarPedidoActionPerformed

    private void RemoverPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverPedidoActionPerformed
        int codigoPedido = Integer.parseInt(txtNumeroPedido.getText());
        int codigoCliente = Integer.parseInt(txtCodigoClientePedido.getText());
        String data = txtDataPedido.getText();
        
        for(int i = 0; i < clientes.size(); i++){
            if(codigoCliente == clientes.get(i).getCpf()){
                Pedido ped = new Pedido(codigoPedido, clientes.get(i), data);
                int resultado = daoPedido.excluir(ped);
                
                if(resultado == 1){
                    JOptionPane.showMessageDialog(this, "Removido com sucesso!");
                    i = clientes.size();
                    break;
                }else {
                    JOptionPane.showMessageDialog(this, "Ops! algo deu errado");
                }
                
                txtCodigoClientePedido.setText("");
                txtNumeroPedido.setText("");
                txtDataPedido.setText("");
            }else{
                JOptionPane.showMessageDialog(this, "Algo está errado! confira e tente novamente");
            }
        }
        criarTabelaPedidos();   
    }//GEN-LAST:event_RemoverPedidoActionPerformed

    private void AtualizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarPedidoActionPerformed
        criarTabelaPedidos();
    }//GEN-LAST:event_AtualizarPedidoActionPerformed

    private void cadastarCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastarCarrinhoActionPerformed
        int numeroPedidoCarrinho = Integer.parseInt(txtNumeroPedidoCarrinho.getText());
        int codigoProduto = Integer.parseInt(txtCodigoProdutoCarrinho.getText());
        int quantidade = Integer.parseInt(txtQuantidadeCarrinho.getText());
        double desconto = Double.parseDouble(txtDescontoCarrinho.getText());
      
        
   
       for(int i =0; i < pedidos.size(); i++){
           if(numeroPedidoCarrinho == pedidos.get(i).getCodigo()){
               for(int x = 0; x < produtos.size(); x++){
                   if(codigoProduto == produtos.get(x).getCodigo()){
                       ItemPedido itemPedido = new ItemPedido(produtos.get(x), quantidade, numeroPedidoCarrinho, desconto); 
                       int resultado = daoItemPedido.gravar(itemPedido);
                        
                       if(resultado == 1){
                            JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!");
                            x = produtos.size();
                            i = pedidos.size();
                            break;
                        }else {
                            JOptionPane.showMessageDialog(this, "Ops! algo deu errado");
                        }
                        
                   }else{
                       JOptionPane.showMessageDialog(this, "Algum código está errado");
                   }
               }
           }
       }
       criarTabelaCarrinho();
    }//GEN-LAST:event_cadastarCarrinhoActionPerformed

    private void alterarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarProdutoActionPerformed
        int codigo = Integer.parseInt(txtCodigoProduto.getText());
        String nome = txtNomeProduto.getText();
        double preco = Double.parseDouble(txtPrecoProduto.getText());
        
        Produto pro = new Produto(codigo, nome, preco);
        
        int resultado = daoProduto.alterar(pro);
        
        if(resultado == 1){
            JOptionPane.showMessageDialog(this, "Alterado com sucesso!");
        }else {
            JOptionPane.showMessageDialog(this, "Ops! algo deu errado");
        }
        
        txtCodigoProduto.setText("");
        txtNomeProduto.setText("");
        txtPrecoProduto.setText("");
        criarTabelaProduto();
    }//GEN-LAST:event_alterarProdutoActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
        int cpf = Integer.parseInt(txtCPF.getText());
        String nome = txtNome.getText();
        String dataNascimento = txtDataNascimento.getText();
        String contato = txtContato.getText();
        
        Cliente cli = new Cliente(cpf, nome, dataNascimento, contato);
        
        int resultado = daoCliente.alterar(cli);
        
        if(resultado == 1){
            JOptionPane.showMessageDialog(this, "Alterado com sucesso!");
        }else {
            JOptionPane.showMessageDialog(this, "Ops! algo deu errado");
        }
        
        
        
        txtCPF.setText("");
        txtNome.setText("");
        txtDataNascimento.setText("");
        txtContato.setText("");
        criarTabela();
    }//GEN-LAST:event_alterarActionPerformed

    private void tableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClientesMouseClicked
        txtCPF.setText(tableClientes.getValueAt(tableClientes.getSelectedRow(), 0).toString());
        txtNome.setText(tableClientes.getValueAt(tableClientes.getSelectedRow(), 1).toString());
        txtDataNascimento.setText(tableClientes.getValueAt(tableClientes.getSelectedRow(), 2).toString());
        txtContato.setText(tableClientes.getValueAt(tableClientes.getSelectedRow(), 3).toString());
        txtCPF.setEditable(false);
        txtCPF.setEnabled(false);
    }//GEN-LAST:event_tableClientesMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtCPF.setEditable(true);
        txtCPF.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tableProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProdutosMouseClicked
        txtCodigoProduto.setText(tableProdutos.getValueAt(tableProdutos.getSelectedRow(), 0).toString());
        txtNomeProduto.setText(tableProdutos.getValueAt(tableProdutos.getSelectedRow(), 1).toString());
        txtPrecoProduto.setText(tableProdutos.getValueAt(tableProdutos.getSelectedRow(), 2).toString());
        txtCodigoProduto.setEditable(false);
        txtCodigoProduto.setEnabled(false);
    }//GEN-LAST:event_tableProdutosMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txtCodigoProduto.setEditable(true);
        txtCodigoProduto.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tabelaPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPedidosMouseClicked
        int numeroPedido = Integer.parseInt(tabelaPedidos.getValueAt(tabelaPedidos.getSelectedRow(), 0).toString());
        itemDePedido = daoItemPedido.produtosPedido(numeroPedido);
        valorTotalPedido.setText(String.valueOf(servicos.calcularTotal(itemDePedido)));
        valorTotalPedido.setForeground(Color.red);
        criarTabelaPedidoProdutos();
        
        txtNumeroPedido.setText(tabelaPedidos.getValueAt(tabelaPedidos.getSelectedRow(), 0).toString());
        txtDataPedido.setText(tabelaPedidos.getValueAt(tabelaPedidos.getSelectedRow(), 1).toString());
        txtCodigoClientePedido.setText(tabelaPedidos.getValueAt(tabelaPedidos.getSelectedRow(), 2).toString());
  
    }//GEN-LAST:event_tabelaPedidosMouseClicked

    private void tabelaCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCarrinhoMouseClicked
        txtQuantidadeCarrinho.setText(tabelaCarrinho.getValueAt(tabelaCarrinho.getSelectedRow(), 0).toString());
        txtCodigoProdutoCarrinho.setText(tabelaCarrinho.getValueAt(tabelaCarrinho.getSelectedRow(), 1).toString());
        txtDescontoCarrinho.setText(tabelaCarrinho.getValueAt(tabelaCarrinho.getSelectedRow(), 4).toString());
        txtNumeroPedidoCarrinho.setText(tabelaCarrinho.getValueAt(tabelaCarrinho.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_tabelaCarrinhoMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        criarTabelaCarrinho();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void excluirItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirItemPedidoActionPerformed
        int numeroPedidoCarrinho = Integer.parseInt(txtNumeroPedidoCarrinho.getText());
        int codigoProduto = Integer.parseInt(txtCodigoProdutoCarrinho.getText());
        int quantidade = Integer.parseInt(txtQuantidadeCarrinho.getText());
        double desconto = Double.parseDouble(txtDescontoCarrinho.getText());
      
   
       for(int i =0; i < pedidos.size(); i++){
           if(numeroPedidoCarrinho == pedidos.get(i).getCodigo()){
               for(int x = 0; x < produtos.size(); x++){
                   if(codigoProduto == produtos.get(x).getCodigo()){
                       ItemPedido itemPedido = new ItemPedido(produtos.get(x), quantidade, numeroPedidoCarrinho, desconto); 
                       int resultado = daoItemPedido.excluir(itemPedido);
                        if(resultado == 1){
                            JOptionPane.showMessageDialog(this, "removido com sucesso com sucesso!");
                            x = produtos.size();
                            i = pedidos.size();
                            break;
                        }else {
                            JOptionPane.showMessageDialog(this, "Ops! algo deu errado");
                        }
                   }else{
                       JOptionPane.showMessageDialog(this, "Algum código está errado");
                   }
               }
           }
       }
       criarTabelaCarrinho();
    }//GEN-LAST:event_excluirItemPedidoActionPerformed

    private void pesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarProdutoActionPerformed
        String nome = (txtPesquisar.getText());
        pro = daoProduto.buscarPorUm(nome);
        JOptionPane.showMessageDialog(this, pro);
        criarTabelaProdutoPesquisado();
    }//GEN-LAST:event_pesquisarProdutoActionPerformed

    private void pesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarClienteActionPerformed
        String nome = (txtNomeCliente.getText());
        cli = daoCliente.buscarPorUm(nome);
        criarTabelaPesquisado();
    }//GEN-LAST:event_pesquisarClienteActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int cpf = Integer.parseInt(txtCPFpesquisa.getText());
        ped = daoPedido.buscarPorUm(cpf);
        criarTabelaPedidosPesquisado();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crud().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtualizarPedido;
    private javax.swing.JPanel Cliente;
    private javax.swing.JButton Remover;
    private javax.swing.JButton RemoverPedido;
    private javax.swing.JButton RemoverProduto;
    private javax.swing.JButton alterar;
    private javax.swing.JButton alterarProduto;
    private javax.swing.JButton atualizarProduto;
    private javax.swing.JButton cadastar;
    private javax.swing.JButton cadastarCarrinho;
    private javax.swing.JButton cadastarPedido;
    private javax.swing.JButton cadastarProduto;
    private javax.swing.JButton excluirItemPedido;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTabbedPane paneCliente;
    private javax.swing.JPanel pedido;
    private javax.swing.JButton pesquisarCliente;
    private javax.swing.JButton pesquisarProduto;
    private javax.swing.JPanel produto;
    private javax.swing.JTable tabelaCarrinho;
    private javax.swing.JTable tabelaPedidoProduto;
    private javax.swing.JTable tabelaPedidos;
    private javax.swing.JTable tableClientes;
    private javax.swing.JTable tableProdutos;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCPFpesquisa;
    private javax.swing.JTextField txtCodigoClientePedido;
    private javax.swing.JTextField txtCodigoProduto;
    private javax.swing.JTextField txtCodigoProdutoCarrinho;
    private javax.swing.JTextField txtContato;
    private javax.swing.JTextField txtDataNascimento;
    private javax.swing.JTextField txtDataPedido;
    private javax.swing.JTextField txtDescontoCarrinho;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtNumeroPedido;
    private javax.swing.JTextField txtNumeroPedidoCarrinho;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtPrecoProduto;
    private javax.swing.JTextField txtQuantidadeCarrinho;
    private javax.swing.JLabel valorTotalPedido;
    // End of variables declaration//GEN-END:variables
}
