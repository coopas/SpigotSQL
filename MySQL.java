package APIs; //CHANGE THIS - MUDE ISSO

import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

public class MySQL {

    public static void criarTabela() { // CREATE A TABLE IN MYSQL - CRIA A TABELA DENTRO DO MYSQL

        try {
            Connection con = abrirConexao();
            PreparedStatement st = con.prepareStatement("CREATE TABLE IF NOT EXISTS MONEY(ID VARCHAR(45),NICK VARCHAR(25),CASH INT);");
            st.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println("§c[MYSQL] ERRO AO CRIAR TABELA!");
        }


    }

    public static Connection abrirConexao() { //OPEN A CONECTION - ABRE CONEXAO

        try {
            String password = "vertrigo";  //CHANGE THIS ACCORDING TO YOUR MYSQL - MUDE ISSO DE ACORDO COM SEU MYSQL
            String user = "root";
            String host = "localhost";
            String port = "3306";
            String database = "mysqlapi"; //CREATE THIS DATABASE IN MYSQL PANEL// CRIE ESSA BASE DE DADOS NO PAINEL MYSQL
            String type = "jdbc:mysql://";
            String url = type+host+":"+port+"/"+database;
            return DriverManager.getConnection(url, user, password);


        } catch (Exception e) {
            System.out.println("§c[MYSQL] ERRO AO ABRIR CONEXAO!");
        }


        return null;
    }

    public static void addJogador(Player player) { // ADD A NEW PLAYER TO THE TABLE - ADICIONA UM NOVO JOGADOR A TABELA
        UUID id = player.getUniqueId();
        String nick = player.getDisplayName();

        try {

            Connection con = abrirConexao();
            PreparedStatement st = con.prepareStatement("INSERT INTO MONEY VALUES (?,?,0);");
            st.setString(1, id.toString());
            st.setString(2, nick);
            st.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println("§c[MYSQL] ERRO AO ADICIONAR JOGADOR!");
        }

    }

    public static double getJogador(Player player) { //SEARCH FOR A SPECIFIC VALUE BASED ON PLAYER UUID - BUSCA UM VALOR ESPECÍFICO COM BASE NO ID DO PLAYER
        double value = 0;
        UUID id = player.getUniqueId();
        try {
            Connection con = abrirConexao();
            PreparedStatement st = con.prepareStatement("SELECT CASH FROM MONEY WHERE ID = ?;");
            st.setString(1, id.toString());
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                value = rs.getDouble("CASH");
            }
            con.close();
        } catch (Exception e) {
            System.out.println("§c[MYSQL] ERRO AO PEGAR INFORMACOES DO JOGADOR");
        }
        return value;
    }


    public static boolean hasJogador(Player player) { // CHECKS IF THE PLAYER EXISTS IN THE TABLE AND RETURNS A BOOLEAN
        UUID id = player.getUniqueId(); // CONFERE SE O JOGADOR EXISTE NA TABELA E RETORNA UM BOOLEAN
        try {

            Connection con = abrirConexao();
            PreparedStatement st = con.prepareStatement("SELECT CASH FROM MONEY WHERE ID = ?;");
            st.setString(1, id.toString());
            ResultSet rs = st.executeQuery();
            boolean result = rs.next();
            con.close();
            return result;

        } catch (Exception e) {
            System.out.println("§c[MYSQL] ERRO AO PEGAR INFORMACOES DO JOGADOR");
        }
        return false;
    }

    public static void setJogador(Player player, int cash) { //PUT A NEW VALUE TO A PLAYER BY HIS UUID - COLOCA UM NOVO VALOR A UM JOGADOR PELO SEU UUID

        UUID id = player.getUniqueId();
        try {

            Connection con = abrirConexao();
            PreparedStatement st = con.prepareStatement("UPDATE MONEY SET CASH = ? WHERE ID = ?;");
            st.setDouble(1, cash);
            st.setString(2, id.toString());
            st.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println("§c[MYSQL] ERRO AO ATUALIZAR JOGADOR!");
        }

    }

    public static void setJogadorNick(String nick, int cash) { //PUT A NEW VALUE TO A PLAYER FOR HIS NICK - COLOCAR UM NOVO VALOR A UM JOGADOR PELO SEU NICK

        String nick1 = nick;
        try {

            Connection con = abrirConexao();
            PreparedStatement st = con.prepareStatement("UPDATE MONEY SET CASH = ? WHERE NICK = ?;");
            st.setDouble(1, cash);
            st.setString(2, nick1);
            st.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println("§c[MYSQL] ERRO AO ATUALIZAR JOGADOR!");
        }

    }

}
