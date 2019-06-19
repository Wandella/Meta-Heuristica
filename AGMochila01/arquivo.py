import random
import statistics
import grafico 

lucro = []
peso = []
qtd_itens = 0.0
capacidade_mochila = 0.0

#Lendo arquivo
def le_arquivo(nome):
    global qtd_itens, lucro,peso,capacidade_mochila;
    i=0
    #arq = open('AGMochila01/'+nome, 'r')
    arq = open('/home/wandella/Documentos/Meta/Trabalhos/Meta-Heuristica/AGMochila01/'+nome, 'r')
    #linha = arq.readline()
    for linha in arq:
        valores = linha.split()
        if i==0:
            qtd_itens = float(valores[0])
            capacidade_mochila = float(valores[1])
            print('Quantidade de itens',qtd_itens,'Capacidade',capacidade_mochila)
        else:   
            lucro.append(float(valores[0]))
            peso.append(float(valores[1]))  
            #print('Lucro', lucro[i-1],'Peso', peso[i-1])
        i=i+1
    arq.close()   

    return lucro,peso


def populacao_inicial(amount):
    return [geracao_individual() for x in range (0,amount)]


def geracao_individual():
    if inicio_pop_ZEROES:
        return [random.randint(0,0) for x in range (0,int(qtd_itens))]
    else:
        return [random.randint(0,1) for x in range (0,int(qtd_itens))]



inicio_pop_ZEROES = False

# Avaliação dos elementos
def fitness(target):
    #print("O target->",target)
    total_value = 0
    total_weight = 0
    index = 0
    for i in target:        
        if index >= qtd_itens:
            break
        if (i == 1):
            total_value = total_value + lucro[index] 
            total_weight = total_weight + peso[index]
            #print("Total Peso",total_weight,"Total valor ",total_value)
        index += 1
        
    #print("Total Peso",total_weight,"> Capacidade Mochila",capacidade_mochila)
    if total_weight > capacidade_mochila:
        pena = total_value - (1000 * (total_weight-capacidade_mochila))
        print("Pena", pena)
        #Capacidade da mochila tem que ser menor que o total
        return pena
    else:
        #print("Olha so o valor", total_value)
        return total_value

#Mutação
def mutate(target):
    """
    troca os elementos de  0 -> 1 ou 1 -> 0.
    """ 
    r = random.randint(0,len(target)-1)
    if target[r] == 1:
        target[r] = 0
    else:
        target[r] = 1

#Evolui a população
def evolve_population(pop):
    #print("POP", pop)
    parent_eligibility = 0.2
    mutation_chance = 0.08
    parent_lottery = 0.05

    parent_length = int(parent_eligibility*len(pop))
    #print(" parent_length", parent_length)
    parents = pop[:parent_length]
    #print(" parents", parents)
    nonparents = pop[parent_length:]
    #print(" nonparents", nonparents)
    # Parent lottery!
    for np in nonparents:
        if parent_lottery > random.random():
            parents.append(np)

    # Mutation lottery... I guess?
    for p in parents:
        if mutation_chance > random.random():
            mutate(p)

    # Breeding! Close the doors, please.
    children = []
    desired_length = len(pop) - len(parents)
    while len(children) < desired_length :
        male = pop[random.randint(0,len(parents)-1)]
        # print("Tamanho pai",male)
        female = pop[random.randint(0,len(parents)-1)] 
        # print("Tamanho mae",female)       
        half = int(len(male)/2)
        # print("Olhaaa-",half)
        child = male[:half] + female[half:] # from start to half from father, from half to end from mother
        if mutation_chance > random.random():
            mutate(child)
        children.append(child)

    parents.extend(children)
    return parents

def main():
    lista = []
    #nome do arquivo
    arquivo = input()
    #arquivo = 'ue'
    #Lendo os itens do arquivo
    lucro,peso = le_arquivo(arquivo)
    # Número máximo de gerações que o algoritmo executará
    GEN_MAX = 30
    #Tamanho da população
    tamanho_populacao = 300
    #print("Quantidade de itens",tamanho_populacao)
    generation = 1

    #Gerar a população inicial
    population = populacao_inicial(tamanho_populacao)
    maior = 0
    
    for count in range(30):
        for g in range(0,GEN_MAX):
            print ("Generation %d with %d" % (generation,len(population)))
            population = sorted(population, key=lambda x: fitness(x), reverse=True)
            for i in population:        
                #print ("%s, fit: %s" % (str(i), fitness(i)))
                print (" fit: %s" % (fitness(i)))
                if float(fitness(i)) >= maior:
                    maior = float(fitness(i))
            population = evolve_population(population) #Retorna toda a população
            generation += 1
        lista.append(maior)
        maior = 0
        generation=1

    print("Debug 1", len(lista))

    print("_________Estatisticas________")
    print("Maior valor->", max(lista),"Menor Valor:",min(lista))
    print("Média->", statistics.mean(lista),"Desvio Padrão:",statistics.pstdev(lista))

    #Gera graficos a partir dos valores passados
    grafico.grafico(lista,arquivo)

if __name__ == "__main__":
    main()
