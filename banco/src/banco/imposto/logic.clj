(ns banco.imposto.logic)

  (defn- esta-na-faixa-isencao?
    [valor]
    (let [limite-imposto-retido-fonte 1000]
      (< valor limite-imposto-retido-fonte)))

  (defn imposto-retido-fonte
    [valor]
    (let [sem-retencao-imposto 0
          retencao-imposto-padrao 0.1]
      (if (esta-na-faixa-isencao? valor)
        sem-retencao-imposto
        (* valor retencao-imposto-padrao))))