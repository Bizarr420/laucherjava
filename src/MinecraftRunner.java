import javax.swing.*;

public class MinecraftRunner {
    public static void installFabric() {
        try {
            Runtime.getRuntime().exec("portablemc start fabric:1.21.1");
            JOptionPane.showMessageDialog(null, "Fabric ha sido instalado correctamente.",
                    "Instalación completada", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo instalar Fabric.",
                    "Error de instalación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void launchMinecraft(String nickname) {
        if (nickname.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa un nickname antes de continuar.",
                    "Nickname requerido", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Asegúrate de que el comando esté formado correctamente
        String command = String.format("java -jar Minecraft.jar --username %s", nickname);

        try {
            // Ejecuta el comando formado
            Runtime.getRuntime().exec(command);
            JOptionPane.showMessageDialog(null, "Minecraft iniciado con el usuario " + nickname + ".",
                    "Minecraft iniciado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo iniciar Minecraft con el usuario especificado.",
                    "Error al iniciar", JOptionPane.ERROR_MESSAGE);
        }
    }
}
