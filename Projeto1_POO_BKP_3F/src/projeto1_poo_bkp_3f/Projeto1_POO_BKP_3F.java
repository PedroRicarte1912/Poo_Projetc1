/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projeto1_poo_bkp_3f;
/**
 *
 * @author Pedro Ricarte Gisler
 * @author Kaio Silva Castilho
 * @author Bruno Olimpio Garcia Lorca
 */
import java.util.Scanner;
import java.util.Arrays;
public class Projeto1_POO_BKP_3F {
    public static void main(String[] args) {
        /**
         *CRIAÇÃO VETORES E MATRIZES
         */
        String[] NomeHospede= new String[200];
        String[] StatusQuarto=new String[100];
        int[] NumeroReserva= new int[100];
        int[][] frigobar=new int [100][4];
        int [] TOTALFrigo= new int[100];
        int[] ValoresProdutos={10,23,98,7};
        String respostaFINAL="S";
        int totalpreco = 0;
        int QCP=0;
        Scanner SoTexto = new Scanner(System.in);
        Scanner SoNumero= new Scanner(System.in);
        /**
         *Início do sistema roda obrigatoriamente pelo menos uma vez
         */
        do{
        System.out.println("Bem-Vindo ao Projeto 1 de POO 3F!!!!!!");
        System.out.println("======================================");
        System.out.println("Selecione: 1-Resevar Quarto  2-Cancelar Reserva  3-Listar Reservas  4-Consultar Hóspede  5-Editar Hóspede  6-Registrar Frigobar  7-Check-OUT");
        int resp = SoNumero.nextInt();
        while(resp<1 || resp>7){
            System.out.println("SELECIONE DENTRE AS OPÇÕES!");
            System.out.println("Selecione: 1-Resevar Quarto  2-Cancelar Reserva  3-Listar Reservas  4-Consultar Hóspede  5-Editar Hóspede  6-Registrar Frigobar  7-Check-OUT");
            int resp2= SoNumero.nextInt();
            resp=resp2;
        }
        switch(resp){
            case 1:
                /**
                 *Inserir Reservas
                 */
                System.out.println("==========Inserir Reserva de Quarto==========");
                System.out.println("Insira o numero do quarto do hóspede:");
                int NumeroQ = SoNumero.nextInt();
                 System.out.println("========================");
                System.out.println("Insira o nome do hóspede:");
                String NomeH= SoTexto.nextLine();
                System.out.println("========================");
                System.out.println("Insira o numero da reserva do hóspede:");
                int NReservaProvisoria=SoNumero.nextInt();
                System.out.println("========================");
                if(NumeroQ<1 || NumeroQ>100){
                    System.out.println("Insira um número de quarto válido ( de 1 a 100):");
                    NumeroQ = SoNumero.nextInt();
                }
                if("ocupado".equals(StatusQuarto[NumeroQ]))
                {
                        System.out.println("O quarto: "+NumeroQ+" está ocupado!");
                        NomeHospede[NumeroQ]="";
                        NumeroReserva[NumeroQ]=-1;
                }
                if(StatusQuarto[NumeroQ]==null)
                {
                        NomeHospede[NumeroQ]=NomeH;
                        NumeroReserva[NumeroQ]=NReservaProvisoria;
                        StatusQuarto[NumeroQ]="ocupado";
                        System.out.println("Reserva de :"+NomeHospede[NumeroQ]+" foi realizada com suceso! Reserva número:"+NumeroReserva[NumeroQ]);
                        System.out.println("========================");
                }
                    
                break;
            case 2:
                /**
                 *Cancelar Reservas por número do quarto
                 */
                System.out.println("==========Cancelas Reserva de Quarto==========");
                System.out.println("Insira o número do quarto:");
                int NQ1= SoNumero.nextInt();
                System.out.println("========================");
                while(NQ1<1 || NQ1>100){
                    System.out.println("Insira um núero de quarto válido ( de 1 a 100)=>");
                    NQ1=SoNumero.nextInt();
                }
                NomeHospede[NQ1]="";
                StatusQuarto[NQ1]="";
                /*deixa o numero da reserva como -1 para diferenciar dos que estão entre 1 e 100*/
                NumeroReserva[NQ1]=-1;
                for(int x=0;x<4;x=x+1){
                    frigobar[NQ1][x]=0;
                }
                break;
            case 3:
                /**
                 *Listar Reservas
                 */
                System.out.println("==========Lista Reservas de Quartos==========");
                for(int valor=0;valor<=100;valor=valor+1){
                    if(NomeHospede[valor]!=null && "ocupado".equals(StatusQuarto[valor]) && NumeroReserva[valor]!=-1)
                    {
                        System.out.println("O quarto: "+valor+" Está ocupado pelo hóspede: "+NomeHospede[valor]+" Número da reserva: "+NumeroReserva[valor]);
                        System.out.println("========================");
                    }
                }
                break;
            case 4:
                /**
                 *Consultar dados do hospede por número do quarto
                 */
                System.out.println("==========Consultar Reservas de Quartos==========");
                System.out.println("Insira o número do quarto:");
                NumeroQ = SoNumero.nextInt();
                System.out.println("========================");
                if(NumeroQ<1 || NumeroQ>100){
                    System.out.println("Insira um número de quarto válido ( de 1 a 100):");
                    NumeroQ = SoNumero.nextInt();
                    System.out.println("========================");
                }
                System.out.println("Número do quarto:"+NumeroQ);
                System.out.println("Nome do hospede: "+NomeHospede[NumeroQ]);
                System.out.println("Número da reserva: "+NumeroReserva[NumeroQ]);
                 System.out.println("========================");
                break;
            case 5:
                /**
                 *Editar hospede por número de quarto
                 */
                System.out.println("==========Editar hospedes==========");
                System.out.println("Insira o número do quarto:");
                NumeroQ = SoNumero.nextInt();
                System.out.println("========================");
                if(NumeroQ<1 || NumeroQ>100){
                    System.out.println("Insira um número de quarto válido ( de 1 a 100):");
                    NumeroQ = SoNumero.nextInt();
                    System.out.println("========================");
                }
                if("".equals(StatusQuarto[NumeroQ])){
                    System.out.println("Esse quarto está sem hospedes");
                }else{
                    System.out.println("O nome do hospede atual é =>"+NomeHospede[NumeroQ]);
                    System.out.println("O número dessa reserva é =>"+NumeroReserva[NumeroQ]);
                    System.out.println("Insira o novo nome do hospede do quarto:");
                    String NN = SoTexto.nextLine();
                    System.out.println("========================");
                    System.out.println("Insira o novo número de reserva:");
                    int NovaReservaN2= SoNumero.nextInt();
                    System.out.println("========================");
                    System.out.println("Insira o novo número de quarto:");
                    int NovoQuartoN2= SoNumero.nextInt();
                    System.out.println("========================");
                    if(NovoQuartoN2<1 || NovoQuartoN2>100){
                    System.out.println("Insira um número de quarto válido ( de 1 a 100):");
                    NovoQuartoN2 = SoNumero.nextInt();
                    System.out.println("========================");
                    }
                    NomeHospede[NovoQuartoN2]=NN;
                    NumeroReserva[NovoQuartoN2]=NovaReservaN2;
                    TOTALFrigo[NovoQuartoN2]=TOTALFrigo[NumeroQ];
                    System.out.println("Atualização realizada com sucesso!!");
                    
                }
                break;
            case 6: 
                /**
                 *Adicionar consumo ao frigobar
                 */
                System.out.println("==========Consumo do Frigobar==========");
                System.out.println("1-Registrar Consumo,2-Consultar consumo do quarto,3-Calcular Valor total Consumido,0-Voltar");
                int escolha = SoNumero.nextInt();
                if(escolha == 1){
                    System.out.println("Digite o quarto");
                    QCP = SoNumero.nextInt();
                    System.out.println("========================");
                    System.out.println("Digite o número do Produto (1-Chocolate,2-Refrigerante,3-Água,4-Suco)");
                    int PRD = SoNumero.nextInt();
                    System.out.println("========================");
                    System.out.println("Digite a quantidade");
                    int quantidade = SoNumero.nextInt();
                    System.out.println("========================");
                    if(PRD >= 0 && PRD < 4 && QCP >= 0 && QCP < 100){
                        frigobar[QCP][PRD] += quantidade;
                        
                        System.out.println("Consumo Registrado!");
                    }
                } 
                else if(escolha == 2){
                    System.out.println("Digite o quarto");
                    QCP = SoNumero.nextInt();
                    if(QCP >= 0 && QCP < 100){
                        System.out.println("Chocolate: " + frigobar[QCP][0]);
                        System.out.println("Refrigerante: " + frigobar[QCP][1]);
                        System.out.println("Água: " + frigobar[QCP][2]);
                        System.out.println("Suco: " + frigobar[QCP][3]);
                    }
                } 
                else if(escolha == 3){
                    System.out.println("Digite o quarto:");
                    QCP = SoNumero.nextInt();
                    if(QCP >= 0 && QCP < 100){
                        int total = 0;
                        int totalfrig=0;
                        for(int k = 0; k < 4; k++){
                            total += frigobar[QCP][k];
                            totalfrig+= frigobar[QCP][k]*ValoresProdutos[k];
                               
                        }
                       
                        TOTALFrigo[QCP]=totalfrig;    
                        System.out.println("Total consumido: " + total+" R$:"+TOTALFrigo[QCP]);
                    }
                }
                break;
            case 7:
                /**
                 *Sistema de Check-OUT
                 */
                System.out.println("==========Check-OUT==========");
                System.out.println("Insira o número do quarto:");
                NumeroQ=SoNumero.nextInt();
                System.out.println("========================");
                while(NumeroQ<1 || NumeroQ>100){
                    System.out.println("Insira um número de quarto válido ( de 1 a 100):");
                    NumeroQ = SoNumero.nextInt();
                    System.out.println("========================");
                }
                if("ocupado".equals(StatusQuarto[NumeroQ])){
                    System.out.println("Insira o número de diárias:");
                    int diarias2 = SoNumero.nextInt();
                    System.out.println("========================");
                    while(diarias2<=0){
                       System.out.println("Insira o número de diárias válido (maior de 0):");
                       diarias2 = SoNumero.nextInt(); 
                    }
                    diarias2=diarias2*100;
                    int PrecoFinal=diarias2+TOTALFrigo[NumeroQ];
                    System.out.println("Nome do Hóspede=> "+NomeHospede[NumeroQ]);
                    System.out.println("Número do quarto que ocupou=> "+NumeroQ);
                    System.out.println("Total de diárias em R$=> "+diarias2);
                    System.out.println("Consumo do frigobar em R$=>"+TOTALFrigo[NumeroQ]);
                    System.out.println("Valor total a ser pago R$ "+PrecoFinal);
                    System.out.println("OBRIGADO(A) PELA ESTADIA VOLTE SEMPRE!!!");
                }
                StatusQuarto[NumeroQ]="";
                TOTALFrigo[NumeroQ]=0;
                NomeHospede[NumeroQ]="";
                NumeroReserva[NumeroQ]=-1;
                break; 
    }
    System.out.println("Deseja continuar a usar o sistema ( N-não ou S-sim)=>");
    respostaFINAL=SoTexto.nextLine();
    while(!respostaFINAL.equals("N") && !respostaFINAL.equals("S")){
        System.out.println("Insira uma resposta válida (N-não ou S-sim)==>");
        respostaFINAL=SoTexto.nextLine();
    }
   }while(!respostaFINAL.equals("N"));
   SoNumero.close();
   SoTexto.close();
   
   System.out.println("OBRIGADO POR USAR O SISTEMA!!!!");
    SoNumero.close();
    SoTexto.close();
  }    
}
