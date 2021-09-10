# Multadd

Veel berekeningen kunnen beknopter worden uitgedrukt met de "multadd" bewerking, die drie operanden neemt en `a * b + c` berekent. Sommige processoren bieden zelfs een hardware-implementatie van deze bewerking voor zwevendekommagetallen (*floating-point* getallen).

1.  Maak een nieuw programma `Multadd.java`.

2.  Schrijf een methode `multadd` die drie `double`'s als parameters accepteert en het resultaat van `a * b + c` teruggeeft.

3.  Schrijf een `main` methode die `multadd` test door het aan te roepen met een paar eenvoudige parameters, zoals `1.0, 2.0, 3.0`.

4.  Schrijf ook in `main`, `multadd` om de volgende waarden te berekenen:

    ```{math}
    :label: one
    \sin \frac{\pi}{4} + \frac{\cos \frac{\pi}{4}}{2}
    ```

    ```{math}
    :label: two
    $\log 10 + \log 20$
    ```

5.  Schrijf een methode genaamd `expSum` die een `double` als parameter accepteert en `multadd` gebruikt om te berekenen:

    ```{math}
    :label: three
    x e^{-x} + \sqrt{1 - e^{-x}}
    ```

    ```{hint}
    De methode om *e* tot een macht te verheffen is `Math.exp`.
    ```

In het laatste deel van deze oefening moet je een methode schrijven die een andere methode aanroept die jij geschreven hebt. Wanneer je dat doet, is het een goed idee om de eerste methode zorgvuldig te testen voordat je aan de tweede gaat werken. Anders zul je misschien twee methoden tegelijk moeten debuggen, wat lastig kan zijn.

Een van de doelen van deze oefening is het oefenen van pattern-matching: de vaardigheid om een specifiek probleem te herkennen als een instantie van een algemene categorie van problemen.