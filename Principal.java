import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.*;

public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        Map<String, List<Funcionario>> funcionarioPorProfissao = new HashMap<>();

        // Dados dos funcionários
        String[][] dados_funcionarios = {
            {"Maria", "18/10/2000", "2009.44", "Operador"},
            {"João", "12/05/1990", "2284.38", "Operador"},
            {"Caio", "02/05/1961", "9836.14", "Coordenador"},
            {"Miguel", "14/10/1988", "19119.88", "Diretor"},
            {"Alice", "05/01/1995", "2234.68", "Recepcionista"},
            {"Heitor", "19/11/1999", "1582.72", "Operador"},
            {"Arthur", "31/03/1993", "4071.84", "Contador"},
            {"Laura", "08/07/1994", "3017.45", "Gerente"},
            {"Heloísa", "24/05/2003", "1606.85", "Eletricista"},
            {"Helena", "02/09/1996", "2799.93", "Gerente"}
        };

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // 3.1 - Inserir todos os funcionários
        try {
            for(String[] dados : dados_funcionarios) {
                String nome = dados[0];
                LocalDate data_nascimento = LocalDate.parse(dados[1], formato);
                BigDecimal salario = new BigDecimal(dados[2]);
                String funcao = dados[3];
    
                Funcionario funcionario = new Funcionario(nome, data_nascimento, salario, funcao);
    
                funcionarios.add(funcionario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        // 3.2 - Remover funcionário "João"
        try {
            Iterator<Funcionario> iterator = funcionarios.iterator();
            List<Funcionario> nova_lista = new ArrayList<>();

            while(iterator.hasNext()) {
                Funcionario funcionario = iterator.next();

                if(!funcionario.getNome().equals("João")) {
                    nova_lista.add(funcionario);
                }
            }
            funcionarios = nova_lista;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        

        // 3.3 - Imprimir todos os funcionários
        System.out.println("*** 3.3 - Imprimir todos os funcionários ***\n");
        try {
            for(Funcionario funcionario : funcionarios) {
                System.out.printf("%s | %s | %s | %s\n", funcionario.getNome(), funcionario.formatarData(funcionario.getData_nascimento()), funcionario.formatarSalario(funcionario.getSalario()), funcionario.getFuncao());
                System.out.println("----------------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("\n--------------------------------------\n");
        }

        
        // 3.4 - Aumentando o salário em 10%
        System.out.println("*** 3.4 - Aumentando o salário em 10% ***\n");
        try {
            for(Funcionario funcionario : funcionarios) {
                Double salario_antigo = funcionario.getSalario().doubleValue();

                Double novo_salario = funcionario.getSalario().doubleValue() * 0.1 + funcionario.getSalario().doubleValue();
                funcionario.setSalario(BigDecimal.valueOf(novo_salario));

                Double valor_aumento = novo_salario - salario_antigo;

                System.out.printf("%s - %s - aumento de: %.2f\n", funcionario.getNome(), funcionario.formatarSalario(funcionario.getSalario()), valor_aumento);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("\n--------------------------------------\n");
        }

        // 3.5 - Agrupar funcionários com um MAP
        try {
            for(Funcionario f : funcionarios) {
                String funcao = f.getFuncao();
                if (!funcionarioPorProfissao.containsKey(funcao)) {
                    funcionarioPorProfissao.put(funcao, new ArrayList<>());
                }
                funcionarioPorProfissao.get(funcao).add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("\n--------------------------------------\n");
        }


        // 3.6 - Retornar os funcionários, agrupados por função
        System.out.println("*** 3.6 - Retornar os funcionários, agrupados por função ***\n");
        try {
            for(Map.Entry<String, List<Funcionario>> entry : funcionarioPorProfissao.entrySet()) {
                String chave = entry.getKey();
                List<Funcionario> valor = entry.getValue();
                System.out.println("Função: " + chave + "\nFuncionário(s): ");

                for(Funcionario f : valor) {
                    System.out.println("Nome: " + f.getNome());
                }

                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("\n--------------------------------------\n");
        }


        // 3.8 - Funcionários que fazem aniversário no mês 10 ou 12
        System.out.println("*** 3.8 - Funcionários que fazem aniversário no mês 10 ou 12 ***\n");
        try {
            for(Funcionario f : funcionarios) {
               int mes = f.getData_nascimento().getMonthValue();
                if (mes == 10 || mes == 12) {
                    System.out.println("Nome: " + f.getNome() + "\nMês: " + mes + "\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("\n--------------------------------------\n");
        }
        


        // 3.9 - Funcionário com maior idade
        System.out.println("*** 3.9 - Funcionário com maior idade ***\n");
        try {
            int maior_idade = Integer.MIN_VALUE;
            String nome_funcionario = null;

            for(Funcionario funcionario : funcionarios) {
                int idade = funcionario.calcularIdade(funcionario.getData_nascimento());

                if (idade > maior_idade) {
                    maior_idade = idade;
                    nome_funcionario = funcionario.getNome();
                }
            }

            System.out.printf("Nome: %s \nIdade: %d", nome_funcionario, maior_idade);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("\n--------------------------------------\n");
        }


        // 3.10 - Funcionários em ordem alfabética
        System.out.println("*** 3.10 - Funcionários em ordem alfabética ***\n");
        try {
            Collections.sort(funcionarios, new Comparator<Funcionario>() {
                public int compare(Funcionario f1, Funcionario f2) {
                    return f1.getNome().compareToIgnoreCase(f2.getNome());
                }
            });

            for(Funcionario funcionario : funcionarios) {
                System.out.println(funcionario.getNome());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("\n--------------------------------------\n");
        }

        // 3.11 - Imprimir total dos salários
        System.out.println("*** 3.11 - Imprimir total dos salários ***\n");
        try {
            Double salario_total = 0.0;
            for(Funcionario funcionario : funcionarios) {
                salario_total += funcionario.getSalario().doubleValue();
            }

            System.out.printf("Salário total: %.2f", salario_total);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("\n--------------------------------------\n");
        }

        
        // 3.12 - Quantos salários mínimos ganha cada funcionário
        System.out.println("*** 3.12 - Quantos salários mínimos ganha cada funcionário ***\n");
        try {
            for(Funcionario funcionario : funcionarios) {
                Double salario_minimo = 1212.00;

                Double salario = funcionario.getSalario().doubleValue();

                Double qtd_salarios_minimos = salario / salario_minimo;

                System.out.printf("%s - %.1f salários mínimos\n", funcionario.getNome(), qtd_salarios_minimos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("\n--------------------------------------\n");
        }
    }
}