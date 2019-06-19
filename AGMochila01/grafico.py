import matplotlib.pyplot as plt

def grafico(l,arquivoNome):
    plt.plot(l)
    plt.savefig("'"+arquivoNome+"'"+".png")
    plt.show()