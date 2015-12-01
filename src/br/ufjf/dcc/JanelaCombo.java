package br.ufjf.dcc;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class JanelaCombo extends JFrame {

    private final JComboBox<String> cbPao;
    private final JComboBox<String> cbRecheio;
    private final JComboBox<String> cbQueijo;
    private final JTextField txtPedido = new JTextField("Faça seu pedido", 30);
    private final JCheckBox chkBacon = new JCheckBox("Bacon");
    private final JCheckBox chkTomate = new JCheckBox("Tomate");
    private final JRadioButton rdLocal = new JRadioButton("No Local");
    private final JRadioButton rdEntrega = new JRadioButton("Entrega");

    public JanelaCombo() throws HeadlessException {
        super("Combo!");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        String[] paes = {"Italiano", "Três queijos", "Parmezão"};
        String[] recheios = {"Carne", "Almôndega", "Frango", "Atum", "Presunto"};
        String[] queijos = {"Prato", "Chedar", "Suíço"};
        cbPao = new JComboBox<>(paes);
        add(cbPao);
        cbRecheio = new JComboBox<>(recheios);
        add(cbRecheio);
        cbQueijo = new JComboBox<>(queijos);
        add(cbQueijo);
        add(chkBacon);
        add(chkTomate);
        add(txtPedido);
        add(rdLocal);
        add(rdEntrega);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rdEntrega);
        bg.add(rdLocal);
        
        txtPedido.setEditable(false);
        PedidoHandler handler = new PedidoHandler();
        cbPao.addItemListener(handler);
        cbRecheio.addItemListener(handler);
        cbQueijo.addItemListener(handler);
        chkBacon.addItemListener(handler);
        chkTomate.addItemListener(handler);
        rdEntrega.addItemListener(handler);
        rdLocal.addItemListener(handler);
    }

    private class PedidoHandler implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            StringBuilder sb = new StringBuilder();
            sb.append(cbPao.getSelectedItem().toString());
            sb.append(" ");
            sb.append(cbRecheio.getSelectedItem().toString());
            sb.append(" ");
            sb.append(cbQueijo.getSelectedItem().toString());
            
            sb.append(chkBacon.isSelected()?" Bacon":"");
            sb.append(chkTomate.isSelected()?" Tomate":"");
            sb.append(rdLocal.isSelected()?" no local":"");
            sb.append(rdEntrega.isSelected()?" Entrega":"");
            txtPedido.setText(sb.toString());
        }
    }

}
