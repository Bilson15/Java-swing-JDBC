package View;

import Dao.DaoCliente;
import Dao.DaoItemEstoque;
import Dao.DaoItemPedido;
import Dao.DaoPedido;
import Dao.DaoProduto;
import Dao.DaoVendedor;
import Dao.Relatorios;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import services.ServicosCrud;
import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import model.ItemEstoque;
import model.Vendedor;

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
    List<Produto> produtosPesquisados;
    List<Cliente> clientesPesquisados;
    List<Pedido> pedidosPesquisados;
    List<ItemEstoque> itemEstoque;
    List<ItemEstoque> itemEstoquePesquisados;
    List<Vendedor> vendedores;
    List<Vendedor> vendedoresPesquisados;
    
    DaoCliente daoCliente;
    DaoProduto daoProduto;
    DaoPedido daoPedido;
    DaoItemPedido daoItemPedido;
    DaoItemEstoque daoItemEstoque;
    DaoVendedor daoVendedor;
    Relatorios relatorios;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    ServicosCrud servicos = new ServicosCrud();
   
            
            public void criarTabela(){
                clientes = daoCliente.buscarTodos();
                DefaultTableModel model = (DefaultTableModel) tableClientes.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[4];
                for(int i = 0; i < clientes.size(); i++){
                    dadosLinha[0] = String.valueOf(clientes.get(i).getCpf());
                    dadosLinha[1] = clientes.get(i).getNome();
                    dadosLinha[2] = sdf.format(clientes.get(i).getDataNascimento());
                    dadosLinha[3] = String.valueOf(clientes.get(i).getContato());
                    model.addRow(dadosLinha);
                }
            }
            public void criarTabelaPesquisado(){
                DefaultTableModel model = (DefaultTableModel) tableClientes.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[4];
                for(int i = 0; i < clientesPesquisados.size(); i++){
                    dadosLinha[0] = String.valueOf(clientesPesquisados.get(i).getCpf());
                    dadosLinha[1] = clientesPesquisados.get(i).getNome();
                    dadosLinha[2] = sdf.format(clientesPesquisados.get(i).getDataNascimento());
                    dadosLinha[3] = String.valueOf(clientesPesquisados.get(i).getContato());
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
            
            public void criarTabelaProdutoCarrinho(){
                DefaultTableModel model = (DefaultTableModel) tableProdutosCarrinho.getModel();
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
                for(int i = 0; i < produtosPesquisados.size(); i++){
                    dadosLinha[0] = String.valueOf(produtosPesquisados.get(i).getCodigo());
                    dadosLinha[1] = produtosPesquisados.get(i).getNome();
                    dadosLinha[2] = String.valueOf(produtosPesquisados.get(i).getPreco());
                    model.addRow(dadosLinha);
                }
            }
            
            public void criarTabelaProdutoPesquisadoCarrinho(){
                DefaultTableModel model = (DefaultTableModel) tableProdutosCarrinho.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[3];
                for(int i = 0; i < produtosPesquisados.size(); i++){
                    dadosLinha[0] = String.valueOf(produtosPesquisados.get(i).getCodigo());
                    dadosLinha[1] = produtosPesquisados.get(i).getNome();
                    dadosLinha[2] = String.valueOf(produtosPesquisados.get(i).getPreco());
                    model.addRow(dadosLinha);
                }
            }
            
            public void criarTabelaPedidos(){
                pedidos = daoPedido.buscarTodosVendedorComissao();
                DefaultTableModel model = (DefaultTableModel) tabelaPedidos.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[6];
                for(int i = 0; i < pedidos.size(); i++){
                    dadosLinha[0] = String.valueOf(pedidos.get(i).getCodigo());
                    dadosLinha[1] = sdf.format(pedidos.get(i).getData());
                    dadosLinha[2] = String.valueOf(pedidos.get(i).getCliente().getCpf());
                    dadosLinha[3] = pedidos.get(i).getCliente().getNome();
                    dadosLinha[4] = String.valueOf(pedidos.get(i).getVendedor().getNome());
                    dadosLinha[5] = String.valueOf(pedidos.get(i).getComissao());
                    model.addRow(dadosLinha);
                }
            }
            public void criarTabelaPedidosPesquisado(){
                DefaultTableModel model = (DefaultTableModel) tabelaPedidos.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[4];
                for(int i = 0; i < pedidosPesquisados.size(); i++){
                    dadosLinha[0] = String.valueOf(pedidosPesquisados.get(i).getCodigo());
                    dadosLinha[1] = sdf.format(pedidosPesquisados.get(i).getData());
                    dadosLinha[2] = String.valueOf(pedidosPesquisados.get(i).getCliente().getCpf());
                    dadosLinha[3] = pedidosPesquisados.get(i).getCliente().getNome();
                    dadosLinha[4] = String.valueOf(pedidosPesquisados.get(i).getVendedor().getNome());
                    dadosLinha[5] = String.valueOf(pedidosPesquisados.get(i).getComissao());
                    model.addRow(dadosLinha);
                }
            }   
            
            public void criarTabelaPedidosPesquisadoCarrinho(){
                DefaultTableModel model = (DefaultTableModel) tabelaPedidosCarrinho.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[4];
                for(int i = 0; i < pedidosPesquisados.size(); i++){
                    dadosLinha[0] = String.valueOf(pedidosPesquisados.get(i).getCodigo());
                    dadosLinha[1] = sdf.format(pedidosPesquisados.get(i).getData());
                    dadosLinha[2] = String.valueOf(pedidosPesquisados.get(i).getCliente().getCpf());
                    dadosLinha[3] = pedidosPesquisados.get(i).getCliente().getNome();
                    model.addRow(dadosLinha);
                }
            }
            public void criarTabelaPedidosCarrinho(){
                pedidos = daoPedido.buscarTodos();
                DefaultTableModel model = (DefaultTableModel) tabelaPedidosCarrinho.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[4];
                for(int i = 0; i < pedidos.size(); i++){
                    dadosLinha[0] = String.valueOf(pedidos.get(i).getCodigo());
                    dadosLinha[1] = sdf.format(pedidos.get(i).getData());
                    dadosLinha[2] = String.valueOf(pedidos.get(i).getCliente().getCpf());
                    dadosLinha[3] = pedidos.get(i).getCliente().getNome();
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
                    dadosLinha[4] = String.valueOf(String.format("%.2f", itemDePedido.get(i).getProduto().getPrecoDesconto()));
                    model.addRow(dadosLinha);
                }
            }
            
            public void criarTabelaCarrinhoPedido(){
                pedidos = daoPedido.buscarTodos();
                DefaultTableModel model = (DefaultTableModel) tabelaPedidosCarrinho.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[4];
                for(int i = 0; i < pedidos.size(); i++){
                    dadosLinha[0] = String.valueOf(pedidos.get(i).getCodigo());
                    dadosLinha[1] = sdf.format(pedidos.get(i).getData());
                    dadosLinha[2] = String.valueOf(pedidos.get(i).getCliente().getCpf());
                    dadosLinha[3] = pedidos.get(i).getCliente().getNome();
                    model.addRow(dadosLinha);
                }
            }
            
            
            
            public void criarTabelaEstoque(){
                itemEstoque = daoItemEstoque.buscarTodos();
                DefaultTableModel model = (DefaultTableModel) tableItemEstoque.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[4];
                for(int i = 0; i < itemEstoque.size(); i++){
                    dadosLinha[0] = String.valueOf(itemEstoque.get(i).getProduto().getCodigo());
                    dadosLinha[1] = itemEstoque.get(i).getProduto().getNome();
                    dadosLinha[2] = String.valueOf(itemEstoque.get(i).getQuantidade());
                    dadosLinha[3] = itemEstoque.get(i).getEstoque().getNome();
                    model.addRow(dadosLinha);
                }
            }
            
            public void criarTabelaEstoquePesquisados(){
                DefaultTableModel model = (DefaultTableModel) tableItemEstoque.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[4];
                for(int i = 0; i < itemEstoquePesquisados.size(); i++){
                    dadosLinha[0] = String.valueOf(itemEstoquePesquisados.get(i).getProduto().getCodigo());
                    dadosLinha[1] = itemEstoquePesquisados.get(i).getProduto().getNome();
                    dadosLinha[2] = String.valueOf(itemEstoquePesquisados.get(i).getQuantidade());
                    dadosLinha[3] = itemEstoquePesquisados.get(i).getEstoque().getNome();
                    model.addRow(dadosLinha);
                }
            }
            
            public void criarTabelaVendedor(){
                vendedores = daoVendedor.buscarTodos();
                DefaultTableModel model = (DefaultTableModel) tableVendedor.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[3];
                for(int i = 0; i < vendedores.size(); i++){
                    dadosLinha[0] = String.valueOf(vendedores.get(i).getMatricula());
                    dadosLinha[1] = vendedores.get(i).getNome();
                    dadosLinha[2] = vendedores.get(i).getContato();
                    model.addRow(dadosLinha);
                }
            }
            
            public void criarTabelaVendedorPesquisado(){
                DefaultTableModel model = (DefaultTableModel) tableVendedor.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[3];
                for(int i = 0; i < vendedoresPesquisados.size(); i++){
                    dadosLinha[0] = String.valueOf(vendedoresPesquisados.get(i).getMatricula());
                    dadosLinha[1] = vendedoresPesquisados.get(i).getNome();
                    dadosLinha[2] = vendedoresPesquisados.get(i).getContato();
                    model.addRow(dadosLinha);
                }
            }
            
            public void criarTabelaVendedorPedido(){
                vendedores = daoVendedor.buscarTodos();
                DefaultTableModel model = (DefaultTableModel) tableVendedorPedido.getModel();
                model.setRowCount(0);
                String dadosLinha[] = new String[3];
                for(int i = 0; i < vendedores.size(); i++){
                    dadosLinha[0] = String.valueOf(vendedores.get(i).getMatricula());
                    dadosLinha[1] = vendedores.get(i).getNome();
                    dadosLinha[2] = vendedores.get(i).getContato();
                    model.addRow(dadosLinha);
                }
            }
              
            
    public Crud(){
        initComponents();
        daoCliente = new DaoCliente();
        daoProduto = new DaoProduto();
        daoPedido = new DaoPedido();
        daoItemPedido = new DaoItemPedido();
        daoItemEstoque = new DaoItemEstoque();
        daoVendedor = new DaoVendedor();
        
        clientes = new ArrayList<>();
        produtos = new ArrayList<>();
        pedidos = new ArrayList<>();
        itemDePedido = new ArrayList<>();
        itemPedidoCarrinho = new ArrayList<>();
        produtosPesquisados = new ArrayList<>();
        clientesPesquisados = new ArrayList<>();
        pedidosPesquisados = new ArrayList<>();
        itemEstoque = new ArrayList<>();
        itemEstoquePesquisados = new ArrayList<>();
        vendedores = new ArrayList<>();
        vendedoresPesquisados = new ArrayList<>();

        clientes = daoCliente.buscarTodos();
        produtos = daoProduto.buscarTodos();
        pedidos = daoPedido.buscarTodos();
        itemPedidoCarrinho = daoItemPedido.buscarTodos();
        itemEstoque = daoItemEstoque.buscarTodos();
        vendedores = daoVendedor.buscarTodos();
        
        relatorios = new Relatorios();

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
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtNomeVendedor = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMatriculaVendedor = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cadastrarVendedor = new javax.swing.JButton();
        removerVendedor = new javax.swing.JButton();
        alterarVendedor = new javax.swing.JButton();
        txtContatoVendedor = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNomeVendedorPesquisa = new javax.swing.JTextField();
        pesquisarVendedor = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        atualizaVendedor = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableVendedor = new javax.swing.JTable();
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
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaPedidos = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaPedidoProduto = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        valorTotalPedido = new javax.swing.JLabel();
        txtCPFpesquisa = new javax.swing.JTextField();
        pesquisaPedido = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableVendedorPedido = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        txtMatriculaVenPedido = new javax.swing.JTextField();
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
        atualizaCarrinho = new javax.swing.JButton();
        excluirItemPedido = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableProdutosCarrinho = new javax.swing.JTable();
        txtPesquisaProdutoCarrinho = new javax.swing.JTextField();
        pesquisaProdCarrinho = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabelaPedidosCarrinho = new javax.swing.JTable();
        pesquisarPedCarrinho = new javax.swing.JButton();
        txtCPFpesquisaCarrinho = new javax.swing.JTextField();
        liberaCaixaCarrinho = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        txtCodigoProdutoEstoque = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtEstoqueNome = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableItemEstoque = new javax.swing.JTable();
        txtQuantidadeProdutoEstoque = new javax.swing.JTextField();
        atualizaQuantidadeEstoque = new javax.swing.JButton();
        txtPesquisaProdutoEstoque2 = new javax.swing.JTextField();
        pesquisaProdEstoque = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        textAreaRelatorio = new javax.swing.JTextArea();
        qtdPedidoPorCliente = new javax.swing.JButton();
        produtoMaisVendido = new javax.swing.JButton();
        pedidoMaiorQueMedia = new javax.swing.JButton();
        produtoMenosVendido = new javax.swing.JButton();
        totalDeTodosPedidos = new javax.swing.JButton();
        ProdutoComEstoqueBaixo = new javax.swing.JButton();
        ValorVendidoDeCadaProduto = new javax.swing.JButton();

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
        setBackground(new java.awt.Color(0, 153, 255));
        setForeground(new java.awt.Color(0, 153, 255));

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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 366, Short.MAX_VALUE)
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

        txtCodigoProduto.setEditable(false);
        txtCodigoProduto.setEnabled(false);

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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 366, Short.MAX_VALUE))
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

        jLabel11.setText("Nome:");

        jLabel13.setText("Matricula:");

        txtMatriculaVendedor.setEditable(false);
        txtMatriculaVendedor.setEnabled(false);

        jButton5.setText("Liberar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel14.setText("Cadastro de VENDEDORES");

        cadastrarVendedor.setText("Cadastar");
        cadastrarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarVendedorActionPerformed(evt);
            }
        });

        removerVendedor.setText("Remover");
        removerVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerVendedorActionPerformed(evt);
            }
        });

        alterarVendedor.setText("Alterar");
        alterarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarVendedorActionPerformed(evt);
            }
        });

        jLabel15.setText("Contato: ");

        pesquisarVendedor.setText("Pesquisar por nome");
        pesquisarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarVendedorActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel20.setText("Lista de Vendedores");

        atualizaVendedor.setText("Atualizar");
        atualizaVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizaVendedorActionPerformed(evt);
            }
        });

        tableVendedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Matricula", "Nome", "Contato"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVendedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVendedorMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableVendedor);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContatoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1179, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cadastrarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNomeVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(159, 159, 159)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtMatriculaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 366, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(atualizaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(alterarVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(removerVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGap(398, 398, 398)
                                    .addComponent(jLabel14))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(txtNomeVendedorPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pesquisarVendedor)
                                    .addGap(205, 205, 205)
                                    .addComponent(jLabel20)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(118, 118, 118)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(cadastrarVendedor)
                .addGap(119, 119, 119)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtContatoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(436, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(55, 55, 55)
                                    .addComponent(jButton5))
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(txtNomeVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)
                                .addComponent(txtMatriculaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(112, 112, 112)
                            .addComponent(removerVendedor)))
                    .addGap(18, 18, 18)
                    .addComponent(alterarVendedor)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(atualizaVendedor, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNomeVendedorPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pesquisarVendedor))
                            .addGap(4, 4, 4)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)))
        );

        paneCliente.addTab("Vendedor", jPanel3);

        jLabel17.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel17.setText("Novo Pedido");

        txtNumeroPedido.setEditable(false);
        txtNumeroPedido.setEnabled(false);

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

        tabelaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Número do Pedido", "Data do Pedido", "CPF Cliente", "Cliente", "Vendedor", "Comissão"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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

        pesquisaPedido.setText("Pesquisar por CPF");
        pesquisaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaPedidoActionPerformed(evt);
            }
        });

        tableVendedorPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Matricula", "Nome", "Contato"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVendedorPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVendedorPedidoMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tableVendedorPedido);

        jLabel16.setText("Matricula Vendedor:");

        javax.swing.GroupLayout pedidoLayout = new javax.swing.GroupLayout(pedido);
        pedido.setLayout(pedidoLayout);
        pedidoLayout.setHorizontalGroup(
            pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pedidoLayout.createSequentialGroup()
                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addGap(490, 490, 490)
                        .addComponent(jLabel27)
                        .addGap(3, 3, 3)
                        .addComponent(valorTotalPedido))
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pedidoLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pedidoLayout.createSequentialGroup()
                                .addGap(360, 360, 360)
                                .addComponent(jLabel23))
                            .addGroup(pedidoLayout.createSequentialGroup()
                                .addGap(526, 526, 526)
                                .addComponent(jLabel17))
                            .addGroup(pedidoLayout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txtNumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pedidoLayout.createSequentialGroup()
                                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pedidoLayout.createSequentialGroup()
                                        .addGap(140, 140, 140)
                                        .addComponent(txtCPFpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pesquisaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pedidoLayout.createSequentialGroup()
                                        .addGap(157, 157, 157)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(txtCodigoClientePedido, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(79, 79, 79)
                                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(AtualizarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pedidoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pedidoLayout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(jLabel22))
                            .addGroup(pedidoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtMatriculaVenPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(89, 89, 89)
                                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RemoverPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cadastarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(259, 259, Short.MAX_VALUE))
        );
        pedidoLayout.setVerticalGroup(
            pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pedidoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pedidoLayout.createSequentialGroup()
                        .addComponent(cadastarPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RemoverPedido)
                        .addGap(51, 51, 51))
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pedidoLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel18))
                            .addGroup(pedidoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtNumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pedidoLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)))
                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel19))
                    .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodigoClientePedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(txtMatriculaVenPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(92, 92, 92)
                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisaPedido)
                    .addComponent(txtCPFpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AtualizarPedido))
                .addGap(24, 24, 24)
                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(valorTotalPedido)))
        );

        paneCliente.addTab("Pedido", pedido);

        jPanel1.setForeground(new java.awt.Color(0, 153, 153));

        jLabel21.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel21.setText("Items de pedido");

        jLabel24.setText("Número pedido:");

        txtCodigoProdutoCarrinho.setEditable(false);
        txtCodigoProdutoCarrinho.setEnabled(false);

        cadastarCarrinho.setText("Lançar Item");
        cadastarCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastarCarrinhoActionPerformed(evt);
            }
        });

        jLabel25.setText("Quantidade: ");

        jLabel26.setText("Código Produto:");

        txtNumeroPedidoCarrinho.setEditable(false);
        txtNumeroPedidoCarrinho.setEnabled(false);

        jLabel28.setText("Desconto: ");

        atualizaCarrinho.setText("Atualizar");
        atualizaCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizaCarrinhoActionPerformed(evt);
            }
        });

        excluirItemPedido.setText("Excluir os item do pedido");
        excluirItemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirItemPedidoActionPerformed(evt);
            }
        });

        tableProdutosCarrinho.setModel(new javax.swing.table.DefaultTableModel(
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
        tableProdutosCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProdutosCarrinhoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tableProdutosCarrinho);

        pesquisaProdCarrinho.setText("Pesquisar por Nome");
        pesquisaProdCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaProdCarrinhoActionPerformed(evt);
            }
        });

        tabelaPedidosCarrinho.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaPedidosCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPedidosCarrinhoMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tabelaPedidosCarrinho);

        pesquisarPedCarrinho.setText("Pesquisar por CPF");
        pesquisarPedCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarPedCarrinhoActionPerformed(evt);
            }
        });

        liberaCaixaCarrinho.setText("Liberar");
        liberaCaixaCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liberaCaixaCarrinhoActionPerformed(evt);
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
                        .addComponent(cadastarCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtCPFpesquisaCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(pesquisarPedCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(atualizaCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(17, 17, 17))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPesquisaProdutoCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(pesquisaProdCarrinho, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(150, 150, 150))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(488, 488, 488)
                        .addComponent(excluirItemPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(liberaCaixaCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(484, 484, 484)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(118, 839, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(liberaCaixaCarrinho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                        .addGap(51, 51, 51)
                        .addComponent(cadastarCarrinho)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pesquisarPedCarrinho)
                            .addComponent(txtCPFpesquisaCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(atualizaCarrinho))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPesquisaProdutoCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pesquisaProdCarrinho))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63)
                .addComponent(excluirItemPedido)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(614, Short.MAX_VALUE)))
        );

        paneCliente.addTab("Carrinho", jPanel1);

        jLabel29.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel29.setText("Estoque");

        txtCodigoProdutoEstoque.setEditable(false);
        txtCodigoProdutoEstoque.setEnabled(false);

        jLabel30.setText("Codigo Produto");

        txtEstoqueNome.setEditable(false);
        txtEstoqueNome.setEnabled(false);

        jLabel32.setText("Estocado em: ");

        jLabel33.setText("Quantidade: ");

        tableItemEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo Produto", "Nome Produto", "Quantidade", "Estoque"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tableItemEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableItemEstoqueMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tableItemEstoque);

        atualizaQuantidadeEstoque.setText("Lançar estoque");
        atualizaQuantidadeEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizaQuantidadeEstoqueActionPerformed(evt);
            }
        });

        pesquisaProdEstoque.setText("Pesquisar por Nome");
        pesquisaProdEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaProdEstoqueActionPerformed(evt);
            }
        });

        jButton4.setText("Atualiza");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoProdutoEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEstoqueNome, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(608, 608, 608))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(atualizaQuantidadeEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(905, 905, 905))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(465, 465, 465)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidadeProdutoEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1008, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtPesquisaProdutoEstoque2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pesquisaProdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txtCodigoProdutoEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstoqueNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(txtQuantidadeProdutoEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(atualizaQuantidadeEstoque)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(txtPesquisaProdutoEstoque2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pesquisaProdEstoque))))
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        paneCliente.addTab("Estoque", jPanel2);

        textAreaRelatorio.setEditable(false);
        textAreaRelatorio.setColumns(20);
        textAreaRelatorio.setRows(5);
        jScrollPane11.setViewportView(textAreaRelatorio);

        qtdPedidoPorCliente.setText("Quantidade de pedido por cliente");
        qtdPedidoPorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtdPedidoPorClienteActionPerformed(evt);
            }
        });

        produtoMaisVendido.setText("Produto mais vendido");
        produtoMaisVendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoMaisVendidoActionPerformed(evt);
            }
        });

        pedidoMaiorQueMedia.setText("Pedido com valor maior que a média");
        pedidoMaiorQueMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoMaiorQueMediaActionPerformed(evt);
            }
        });

        produtoMenosVendido.setText("Produto menos vendido");
        produtoMenosVendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoMenosVendidoActionPerformed(evt);
            }
        });

        totalDeTodosPedidos.setText("Total de todos pedidos");
        totalDeTodosPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalDeTodosPedidosActionPerformed(evt);
            }
        });

        ProdutoComEstoqueBaixo.setText("Produto com estoque abaixo de 10");
        ProdutoComEstoqueBaixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdutoComEstoqueBaixoActionPerformed(evt);
            }
        });

        ValorVendidoDeCadaProduto.setText("Valor vendido de cada produto");
        ValorVendidoDeCadaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorVendidoDeCadaProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtdPedidoPorCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(produtoMaisVendido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pedidoMaiorQueMedia, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addComponent(produtoMenosVendido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalDeTodosPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProdutoComEstoqueBaixo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ValorVendidoDeCadaProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(854, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(qtdPedidoPorCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(produtoMaisVendido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(produtoMenosVendido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalDeTodosPedidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pedidoMaiorQueMedia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProdutoComEstoqueBaixo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ValorVendidoDeCadaProduto)))
                .addContainerGap(159, Short.MAX_VALUE))
        );

        paneCliente.addTab("Relatórios", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(paneCliente)
                .addGap(57, 57, 57))
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
        Long cpf = Long.parseLong((txtCPF.getText()));

        String nome = txtNome.getText();
        Date dataNascimento = null;
        
        try {
            dataNascimento = sdf.parse(txtDataNascimento.getText());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Insira a data com o formado 01-01-2000");
        }
        
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
        Long cpf = Long.parseLong(txtCPF.getText());
        String nome = txtNome.getText();
        Date dataNascimento = null;
        
        try {
            dataNascimento = sdf.parse(txtDataNascimento.getText());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Insira a data com o formado 01-01-2000");
        }
        
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
        int codigo = 0;
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
        int matricula = 0;
        Long codigoCliente = Long.parseLong(txtCodigoClientePedido.getText());
        
        if(txtMatriculaVenPedido.getText().equals("")){
            matricula = 0;  
        }else{
            matricula = Integer.parseInt(txtMatriculaVenPedido.getText());
        }
             
        int resultado = 0;
        
        for(int i = 0; i < clientes.size(); i++){
            if(codigoCliente.equals(clientes.get(i).getCpf())){
                Pedido ped = new Pedido(clientes.get(i));            
                
                if(matricula != 0){
                    for(int v = 0; v < vendedores.size(); v++){
                        if(matricula == vendedores.get(v).getMatricula()){
                            ped.setVendedor(vendedores.get(v));
                            resultado = daoPedido.gravarComVendedor(ped);
                        }
                    }
                }else{
                    resultado = daoPedido.gravar(ped);
                }
                
                
                
                
                if(resultado == 1){
                    JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!");
                    i = clientes.size();
                }else {
                    JOptionPane.showMessageDialog(this, "Ops! algo deu errado");
                }
                
                txtCodigoClientePedido.setText("");
                txtNumeroPedido.setText("");
            }
        }
       if(resultado != 1){
           JOptionPane.showMessageDialog(this, "Algum código está errado");
       }
        criarTabelaPedidos();
        
    }//GEN-LAST:event_cadastarPedidoActionPerformed

    private void RemoverPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverPedidoActionPerformed
        int codigoPedido = Integer.parseInt(txtNumeroPedido.getText());
        Long codigoCliente = Long.parseLong(txtCodigoClientePedido.getText());
              
        int resultado = 0;
        
        for(int i = 0; i < clientes.size(); i++){
            if(codigoCliente.equals(clientes.get(i).getCpf())){
                Pedido ped = new Pedido(codigoPedido, clientes.get(i));
                resultado = daoPedido.excluir(ped);
                
                if(resultado == 1){
                    JOptionPane.showMessageDialog(this, "Removido com sucesso!");
                    i = clientes.size();
                }else {
                    JOptionPane.showMessageDialog(this, "Ops! algo deu errado");
                }
                
                txtCodigoClientePedido.setText("");
                txtNumeroPedido.setText("");
            }
        }
       if(resultado != 1){
           JOptionPane.showMessageDialog(this, "Algum código está errado");
       }
        criarTabelaPedidos();   
    }//GEN-LAST:event_RemoverPedidoActionPerformed

    private void AtualizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarPedidoActionPerformed
        criarTabelaPedidos();
        criarTabelaVendedorPedido();
    }//GEN-LAST:event_AtualizarPedidoActionPerformed

    private void cadastarCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastarCarrinhoActionPerformed
        int numeroPedidoCarrinho = Integer.parseInt(txtNumeroPedidoCarrinho.getText());
        int codigoProduto = Integer.parseInt(txtCodigoProdutoCarrinho.getText());
        int quantidade;
        double desconto;
        
        if(txtQuantidadeCarrinho.getText().equals("")){
            quantidade = 1;
          
        }else {
            quantidade = Integer.parseInt(txtQuantidadeCarrinho.getText());
        }
        if(txtDescontoCarrinho.getText().equals("")){
            desconto = 0;
        }else{
            desconto = Double.parseDouble(txtDescontoCarrinho.getText());
        }
        
      
        int resultado = 0;
        
        if(quantidade <= 0){
            quantidade = 1;
            JOptionPane.showMessageDialog(this, "Quantidade invalida, lançado como padrão de 1 unidade");
        }
        if(desconto < 0 || desconto > 100){
            desconto = 0;
            JOptionPane.showMessageDialog(this, "Desconto invalida, lançado como padrão de 0% desconto");
        }
        
   
       for(int i =0; i < pedidos.size(); i++){
           if(numeroPedidoCarrinho == pedidos.get(i).getCodigo()){
               for(int x = 0; x < produtos.size(); x++){
                   if(codigoProduto == produtos.get(x).getCodigo()){
                       ItemPedido itemPedido = new ItemPedido(produtos.get(x), quantidade, numeroPedidoCarrinho, desconto); 
                       resultado = daoItemPedido.gravar(itemPedido);
                        
                       if(resultado == 1){
                            JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!");
                            x = produtos.size();
                            i = pedidos.size();
                        }else {
                            JOptionPane.showMessageDialog(this, "Ops! algo deu errado");
                        }
                        
                   }
               }
           }
       }
       if(resultado != 1){
           JOptionPane.showMessageDialog(this, "Algum código está errado");
       }
       criarTabelaPedidoProdutos();
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
        Long cpf = Long.parseLong(txtCPF.getText());
        String nome = txtNome.getText();
        Date dataNascimento = null;
        
        try {
            dataNascimento = sdf.parse(txtDataNascimento.getText());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Insira a data com o formado 01-01-2000");
        }
        
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

    private void tabelaPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPedidosMouseClicked
        int numeroPedido = Integer.parseInt(tabelaPedidos.getValueAt(tabelaPedidos.getSelectedRow(), 0).toString());
        itemDePedido = daoItemPedido.produtosPedido(numeroPedido);
        valorTotalPedido.setText(String.valueOf(String.format("%.2f", servicos.calcularTotal(itemDePedido))));
        valorTotalPedido.setForeground(Color.red);
        criarTabelaPedidoProdutos();
        
        txtNumeroPedido.setText(tabelaPedidos.getValueAt(tabelaPedidos.getSelectedRow(), 0).toString());
        txtCodigoClientePedido.setText(tabelaPedidos.getValueAt(tabelaPedidos.getSelectedRow(), 2).toString());
  
    }//GEN-LAST:event_tabelaPedidosMouseClicked

    private void atualizaCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizaCarrinhoActionPerformed
        criarTabelaPedidosCarrinho();
        criarTabelaProdutoCarrinho();
    }//GEN-LAST:event_atualizaCarrinhoActionPerformed

    private void excluirItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirItemPedidoActionPerformed
        int numeroPedidoCarrinho = Integer.parseInt(txtNumeroPedidoCarrinho.getText());
        int codigoProduto = Integer.parseInt(txtCodigoProdutoCarrinho.getText());
        int quantidade = 0;
        double desconto = 0;
      
       int resultado = 0;
       for(int i =0; i < pedidos.size(); i++){
           if(numeroPedidoCarrinho == pedidos.get(i).getCodigo()){
               for(int x = 0; x < produtos.size(); x++){
                   if(codigoProduto == produtos.get(x).getCodigo()){
                       ItemPedido itemPedido = new ItemPedido(produtos.get(x), quantidade, numeroPedidoCarrinho, desconto); 
                       resultado = daoItemPedido.excluir(itemPedido);
                        if(resultado == 1){
                            JOptionPane.showMessageDialog(this, "removido com sucesso com sucesso!");
                            x = produtos.size();
                            i = pedidos.size();
                        }else {
                            JOptionPane.showMessageDialog(this, "Ops! algo deu errado");
                        }
                   }
               }
           }
       }
       if(resultado != 1){
           JOptionPane.showMessageDialog(this, "Algum código está errado");
       }
       criarTabelaPedidoProdutos();
    }//GEN-LAST:event_excluirItemPedidoActionPerformed

    private void pesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarProdutoActionPerformed
        String nome = (txtPesquisar.getText());
        produtosPesquisados = daoProduto.buscarPorUm(nome);
        criarTabelaProdutoPesquisado();
    }//GEN-LAST:event_pesquisarProdutoActionPerformed

    private void pesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarClienteActionPerformed
        String nome = (txtNomeCliente.getText());
        clientesPesquisados = daoCliente.buscarPorUm(nome);
        criarTabelaPesquisado();
    }//GEN-LAST:event_pesquisarClienteActionPerformed

    private void pesquisaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaPedidoActionPerformed
        int cpf = Integer.parseInt(txtCPFpesquisa.getText());
        pedidosPesquisados = daoPedido.buscarPorUm(cpf);
        criarTabelaPedidosPesquisado();
    }//GEN-LAST:event_pesquisaPedidoActionPerformed

    private void tableProdutosCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProdutosCarrinhoMouseClicked
        txtCodigoProdutoCarrinho.setText(tableProdutosCarrinho.getValueAt(tableProdutosCarrinho.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tableProdutosCarrinhoMouseClicked

    private void pesquisaProdCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaProdCarrinhoActionPerformed
        String nome = (txtPesquisaProdutoCarrinho.getText());
        produtosPesquisados = daoProduto.buscarPorUm(nome);
        criarTabelaProdutoPesquisadoCarrinho();
    }//GEN-LAST:event_pesquisaProdCarrinhoActionPerformed

    private void tabelaPedidosCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPedidosCarrinhoMouseClicked
        txtNumeroPedidoCarrinho.setText(tabelaPedidosCarrinho.getValueAt(tabelaPedidosCarrinho.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tabelaPedidosCarrinhoMouseClicked

    private void pesquisarPedCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarPedCarrinhoActionPerformed
        int cpf = Integer.parseInt(txtCPFpesquisaCarrinho.getText());
        pedidosPesquisados = daoPedido.buscarPorUm(cpf);
        criarTabelaPedidosPesquisadoCarrinho();
    }//GEN-LAST:event_pesquisarPedCarrinhoActionPerformed

    private void liberaCaixaCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liberaCaixaCarrinhoActionPerformed
        txtCodigoProdutoCarrinho.setEditable(true);
        txtCodigoProdutoCarrinho.setEnabled(true);
        txtNumeroPedidoCarrinho.setEditable(true);
        txtNumeroPedidoCarrinho.setEnabled(true);
        txtCodigoProdutoCarrinho.setText("");
        txtNumeroPedidoCarrinho.setText("");
    }//GEN-LAST:event_liberaCaixaCarrinhoActionPerformed

    private void tableItemEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableItemEstoqueMouseClicked

        txtCodigoProdutoEstoque.setText(tableItemEstoque.getValueAt(tableItemEstoque.getSelectedRow(), 0).toString());
        txtEstoqueNome.setText(tableItemEstoque.getValueAt(tableItemEstoque.getSelectedRow(), 3).toString());
        
    }//GEN-LAST:event_tableItemEstoqueMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txtCodigoProduto.setEditable(true);
        txtCodigoProduto.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void pesquisaProdEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaProdEstoqueActionPerformed
        String pesquisado = txtPesquisaProdutoEstoque2.getText();    
        itemEstoquePesquisados = daoItemEstoque.buscarPorNomeProduto(pesquisado);      
        criarTabelaEstoquePesquisados();
        
    }//GEN-LAST:event_pesquisaProdEstoqueActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        criarTabelaEstoque();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void atualizaQuantidadeEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizaQuantidadeEstoqueActionPerformed
        int quantidade = Integer.parseInt(txtQuantidadeProdutoEstoque.getText());
        int codigoProduto = Integer.parseInt(txtCodigoProdutoEstoque.getText());
        int resultado = 0;
            for(int i = 0; i < produtos.size(); i++){
                if(codigoProduto == produtos.get(i).getCodigo()){

                    resultado = daoItemEstoque.atualizaQuantidadeEstoque(quantidade, codigoProduto);

                    if(resultado == 1){
                         JOptionPane.showMessageDialog(this, "Atualizado com sucesso!");
                         i = produtos.size();
                     }else {
                         JOptionPane.showMessageDialog(this, "Ops! algo deu errado");
                     }

                }
            }
        
        
    }//GEN-LAST:event_atualizaQuantidadeEstoqueActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cadastrarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarVendedorActionPerformed
        String nome = txtNomeVendedor.getText();
        String contato = txtContatoVendedor.getText();
        
        int resultado;
        
        Vendedor vendedor = new Vendedor(nome, contato);
       
        resultado = daoVendedor.gravar(vendedor);
        
        if(resultado == 1){
            JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!");
        }else {
            JOptionPane.showMessageDialog(this, "Ops! algo deu errado");
        }
        
        
        txtNomeVendedor.setText("");
        txtContatoVendedor.setText("");
        txtMatriculaVendedor.setText("");     
        criarTabelaVendedor();
    }//GEN-LAST:event_cadastrarVendedorActionPerformed

    private void removerVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerVendedorActionPerformed
        int mat = Integer.parseInt(txtMatriculaVendedor.getText());
        String nome = txtNomeVendedor.getText();
        String contato = txtContatoVendedor.getText();
        
        int resultado;
        
        Vendedor vendedor = new Vendedor(nome, contato);
        vendedor.setMatricula(mat);
       
        resultado = daoVendedor.excluir(vendedor);
        
        if(resultado == 1){
            JOptionPane.showMessageDialog(this, "Removido com sucesso!");
        }else {
            JOptionPane.showMessageDialog(this, "Ops! algo deu errado");
        }
        
        
        txtNomeVendedor.setText("");
        txtContatoVendedor.setText("");
        txtMatriculaVendedor.setText("");     
        criarTabelaVendedor();
    }//GEN-LAST:event_removerVendedorActionPerformed

    private void alterarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarVendedorActionPerformed
        int mat = Integer.parseInt(txtMatriculaVendedor.getText());
        String nome = txtNomeVendedor.getText();
        String contato = txtContatoVendedor.getText();
        
        int resultado;
        
        Vendedor vendedor = new Vendedor(nome, contato);
        vendedor.setMatricula(mat);
       
        resultado = daoVendedor.alterar(vendedor);
        
        if(resultado == 1){
            JOptionPane.showMessageDialog(this, "Alterado com sucesso!");
        }else {
            JOptionPane.showMessageDialog(this, "Ops! algo deu errado");
        }
        
        
        txtNomeVendedor.setText("");
        txtContatoVendedor.setText("");
        txtMatriculaVendedor.setText("");     
        criarTabelaVendedor();          
        
    }//GEN-LAST:event_alterarVendedorActionPerformed

    private void pesquisarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarVendedorActionPerformed
        String pesquisa = txtNomeVendedorPesquisa.getText();
        vendedoresPesquisados = daoVendedor.buscarPorUm(pesquisa);
        criarTabelaVendedorPesquisado();
        
        
    }//GEN-LAST:event_pesquisarVendedorActionPerformed

    private void atualizaVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizaVendedorActionPerformed
        criarTabelaVendedor();
    }//GEN-LAST:event_atualizaVendedorActionPerformed

    private void tableVendedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVendedorMouseClicked
        txtMatriculaVendedor.setText(tableVendedor.getValueAt(tableVendedor.getSelectedRow(), 0).toString());
        txtNomeVendedor.setText(tableVendedor.getValueAt(tableVendedor.getSelectedRow(), 1).toString());
        txtContatoVendedor.setText(tableVendedor.getValueAt(tableVendedor.getSelectedRow(), 2).toString());
  
        
    }//GEN-LAST:event_tableVendedorMouseClicked

    private void tableVendedorPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVendedorPedidoMouseClicked
        txtMatriculaVenPedido.setText(tableVendedorPedido.getValueAt(tableVendedorPedido.getSelectedRow(), 0).toString());
  
    }//GEN-LAST:event_tableVendedorPedidoMouseClicked

    private void produtoMaisVendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoMaisVendidoActionPerformed
        textAreaRelatorio.setText(relatorios.produtoMaisVendido());
    }//GEN-LAST:event_produtoMaisVendidoActionPerformed

    private void qtdPedidoPorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtdPedidoPorClienteActionPerformed
        textAreaRelatorio.setText(relatorios.quantidadePedidosCliente());
    }//GEN-LAST:event_qtdPedidoPorClienteActionPerformed

    private void produtoMenosVendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoMenosVendidoActionPerformed
        textAreaRelatorio.setText(relatorios.produtoMenosVendido());
    }//GEN-LAST:event_produtoMenosVendidoActionPerformed

    private void totalDeTodosPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalDeTodosPedidosActionPerformed
        textAreaRelatorio.setText(relatorios.totalPedido());
    }//GEN-LAST:event_totalDeTodosPedidosActionPerformed

    private void pedidoMaiorQueMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoMaiorQueMediaActionPerformed
        textAreaRelatorio.setText(relatorios.pedidoValorMaiorMedia());
    }//GEN-LAST:event_pedidoMaiorQueMediaActionPerformed

    private void ProdutoComEstoqueBaixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdutoComEstoqueBaixoActionPerformed
        textAreaRelatorio.setText(relatorios.produtoComEstoqueMenor10());
    }//GEN-LAST:event_ProdutoComEstoqueBaixoActionPerformed

    private void ValorVendidoDeCadaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorVendidoDeCadaProdutoActionPerformed
        textAreaRelatorio.setText(relatorios.valorTotalVendidoPorProduto());
    }//GEN-LAST:event_ValorVendidoDeCadaProdutoActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Crud().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtualizarPedido;
    private javax.swing.JPanel Cliente;
    private javax.swing.JButton ProdutoComEstoqueBaixo;
    private javax.swing.JButton Remover;
    private javax.swing.JButton RemoverPedido;
    private javax.swing.JButton RemoverProduto;
    private javax.swing.JButton ValorVendidoDeCadaProduto;
    private javax.swing.JButton alterar;
    private javax.swing.JButton alterarProduto;
    private javax.swing.JButton alterarVendedor;
    private javax.swing.JButton atualizaCarrinho;
    private javax.swing.JButton atualizaQuantidadeEstoque;
    private javax.swing.JButton atualizaVendedor;
    private javax.swing.JButton atualizarProduto;
    private javax.swing.JButton cadastar;
    private javax.swing.JButton cadastarCarrinho;
    private javax.swing.JButton cadastarPedido;
    private javax.swing.JButton cadastarProduto;
    private javax.swing.JButton cadastrarVendedor;
    private javax.swing.JButton excluirItemPedido;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton liberaCaixaCarrinho;
    private javax.swing.JTabbedPane paneCliente;
    private javax.swing.JPanel pedido;
    private javax.swing.JButton pedidoMaiorQueMedia;
    private javax.swing.JButton pesquisaPedido;
    private javax.swing.JButton pesquisaProdCarrinho;
    private javax.swing.JButton pesquisaProdEstoque;
    private javax.swing.JButton pesquisarCliente;
    private javax.swing.JButton pesquisarPedCarrinho;
    private javax.swing.JButton pesquisarProduto;
    private javax.swing.JButton pesquisarVendedor;
    private javax.swing.JPanel produto;
    private javax.swing.JButton produtoMaisVendido;
    private javax.swing.JButton produtoMenosVendido;
    private javax.swing.JButton qtdPedidoPorCliente;
    private javax.swing.JButton removerVendedor;
    private javax.swing.JTable tabelaPedidoProduto;
    private javax.swing.JTable tabelaPedidos;
    private javax.swing.JTable tabelaPedidosCarrinho;
    private javax.swing.JTable tableClientes;
    private javax.swing.JTable tableItemEstoque;
    private javax.swing.JTable tableProdutos;
    private javax.swing.JTable tableProdutosCarrinho;
    private javax.swing.JTable tableVendedor;
    private javax.swing.JTable tableVendedorPedido;
    private javax.swing.JTextArea textAreaRelatorio;
    private javax.swing.JButton totalDeTodosPedidos;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCPFpesquisa;
    private javax.swing.JTextField txtCPFpesquisaCarrinho;
    private javax.swing.JTextField txtCodigoClientePedido;
    private javax.swing.JTextField txtCodigoProduto;
    private javax.swing.JTextField txtCodigoProdutoCarrinho;
    private javax.swing.JTextField txtCodigoProdutoEstoque;
    private javax.swing.JTextField txtContato;
    private javax.swing.JTextField txtContatoVendedor;
    private javax.swing.JTextField txtDataNascimento;
    private javax.swing.JTextField txtDescontoCarrinho;
    private javax.swing.JTextField txtEstoqueNome;
    private javax.swing.JTextField txtMatriculaVenPedido;
    private javax.swing.JTextField txtMatriculaVendedor;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtNomeVendedor;
    private javax.swing.JTextField txtNomeVendedorPesquisa;
    private javax.swing.JTextField txtNumeroPedido;
    private javax.swing.JTextField txtNumeroPedidoCarrinho;
    private javax.swing.JTextField txtPesquisaProdutoCarrinho;
    private javax.swing.JTextField txtPesquisaProdutoEstoque2;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtPrecoProduto;
    private javax.swing.JTextField txtQuantidadeCarrinho;
    private javax.swing.JTextField txtQuantidadeProdutoEstoque;
    private javax.swing.JLabel valorTotalPedido;
    // End of variables declaration//GEN-END:variables
}
