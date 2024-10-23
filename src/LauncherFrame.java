import javax.swing.*;
import java.awt.*;

public class LauncherFrame extends JFrame {
    private JPanel loginPanel;
    private JTextField nicknameField;
    private JButton nextButton;
    private JButton launchButton;
    private JButton installFabricButton;
    private JLabel userGreetingLabel;

    public LauncherFrame() {
        super("Minecraft Launcher");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLayout(new BorderLayout());
        initializeLoginComponents();
    }

    private void initializeLoginComponents() {
        loginPanel = new JPanel(new FlowLayout());

        nicknameField = new JTextField(20);
        nextButton = new JButton("Siguiente");
        nextButton.addActionListener(e -> setupUser());

        loginPanel.add(new JLabel("Ingresa tu nickname para jugar:"));
        loginPanel.add(nicknameField);
        loginPanel.add(nextButton);

        add(loginPanel, BorderLayout.CENTER);
    }

    private void setupUser() {
        String nickname = nicknameField.getText().trim();
        if (nickname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un nickname antes de continuar.",
                    "Nickname requerido", JOptionPane.WARNING_MESSAGE);
            return;
        }

        remove(loginPanel); // Remover el panel de login

        setLayout(new BorderLayout());
        userGreetingLabel = new JLabel("Bienvenido " + nickname + ", ¡listo para jugar!");
        userGreetingLabel.setHorizontalAlignment(JLabel.CENTER);

        installFabricButton = new JButton("Instalar Fabric");
        installFabricButton.addActionListener(e -> MinecraftRunner.installFabric());

        launchButton = new JButton("Iniciar Minecraft");
        launchButton.addActionListener(e -> MinecraftRunner.launchMinecraft(nickname));

        JPanel northPanel = new JPanel();
        northPanel.add(userGreetingLabel);

        JPanel southPanel = new JPanel();
        southPanel.add(installFabricButton);
        southPanel.add(launchButton);

        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);

        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LauncherFrame frame = new LauncherFrame();
            frame.setVisible(true);
        });
    }
}
