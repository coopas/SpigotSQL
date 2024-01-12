<div align="center">
  <img width="200" height="200" src="https://cdn-icons-png.flaticon.com/512/5968/5968282.png"/>
<h1>MySQL simple API for Spigot plugin</h1>
</div>

<div align="center">

## 🚨 Sobre

 This project was made by [Coopas](https://github.com/Coopas), <img src="https://hatscripts.github.io/circle-flags/flags/br.svg" width="11"> Naturally Brazilian, forgive me for any English mistakes<br> </div>
 
<img src="https://hatscripts.github.io/circle-flags/flags/us.svg" width="12"> This API is to make your life easier and give you an idea of ​​how to use MYSQL with spigot, however I recommend that you study MYSQL to learn about<br>
<br><img src="https://hatscripts.github.io/circle-flags/flags/br.svg" width="12"> Essa API e para facilitar sua vida e lhe dar um parecer de como utilizar MYSQL com spigot, porem eu recomendo que voce estude MYSQL para aprender sobre 


## 📁 Libraries & dependencies
 - [SPIGOT - 1.12.2](https://www.spigotmc.org/wiki/spigot-maven/)<br>
 - [MYSQL](https://github.com/mysql)

## ❔ How to use / Como usar

<h3> Step 1 / Passo 1 </h3> 
<div>
<img src="https://hatscripts.github.io/circle-flags/flags/us.svg" width="12"> Go to the "abrirConexao" function and change the storage settings <br>
<img src="https://hatscripts.github.io/circle-flags/flags/br.svg" width="12"> Ir ate a função "abrirConexao" e alterar as configurações de armazenamento. <br>
<img src="https://cdn.discordapp.com/attachments/1190518890313306173/1195457254921617488/image.png?ex=65b40f54&is=65a19a54&hm=8ac2ec74a87c53f9906523afb0eabbde508bdcdcb98e0e2acc7a4ee691027006&" width="400">
</div>


<h3> Step 2 / Passo 2 </h3> 
<div>
<img src="https://hatscripts.github.io/circle-flags/flags/us.svg" width="12"> Add the function that creates the table to OnEnable in your Main <br>
<img src="https://hatscripts.github.io/circle-flags/flags/br.svg" width="12"> Adicionar a função que cria a tabela ao OnEnable em sua Main. <br>
<img src="https://cdn.discordapp.com/attachments/1190518890313306173/1195457984084586516/image.png?ex=65b41001&is=65a19b01&hm=9a787ac2c0508c1cc2c1a8e77df0438cfdd59a3a7e0f35aa8ccfc13898384dff" width="400">
</div>

## 🚨 Final considerations / Considerações Finais 
<img src="https://hatscripts.github.io/circle-flags/flags/us.svg" width="12"> If I helped, follow me on GitHub, I will post new API's to help and projects here too.
Feel free to fork this project and improve it, as well as use it in your codes freely, as long as you make clear my credits and ownership of this project.<br>
<br><img src="https://hatscripts.github.io/circle-flags/flags/br.svg" width="12"> Se eu ajudei, siga-me no GitHub, irei postar novas API's para auxiliar e projetos aqui também.
Sinta-se livre para dar fork nesse projeto e aprimorá-lo, assim como utilizá-lo em seus codigos livremente, contanto que deixe bem claro meus créditos e propriedade sobre esse projeto.


## 🏗️ Command example / Exemplo de comando
<div>

        Player p = (Player)sender;


        if(cmd.getName().equalsIgnoreCase("money")) {

            if(args.length == 0) {
                double value = MySQL.getJogador(p);
                p.sendMessage("Seu money é: " + value);

            } else {
                if(args.length == 3) {
                    if(p.hasPermission("money.set")) {
                    if(args[0].equalsIgnoreCase("set")) {
                            Player target = Bukkit.getServer().getPlayer(args[1]);
                            if (target == null) {
                                p.sendMessage("Selecione um player valido");
                                return false;
                            } else {
                                String valor = args[2];
                                if (valor.matches("\\d+")) {
                                    double valor2 = Double.parseDouble(valor);
                                    MySQL.setJogador(target, valor2);
                                    p.sendMessage("O dinheiro de "+target.getName()+" foi setado para " + valor2);
                                } else {
                                    p.sendMessage(valor + " Nao é um valor valido");
                                }
                            }
                        }
                    } else {
                        p.sendMessage("Voce nao possui permissao");
                    }
                } else {
                    if(args.length < 3) {
                        if(args[0].equalsIgnoreCase("set")) {
                            p.sendMessage("Utilize /money set <Nick> <Money>");
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

</div>
