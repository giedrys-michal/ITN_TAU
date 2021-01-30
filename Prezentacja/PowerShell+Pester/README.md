# PowerShell + Pester testing framework

Pester jest framworkiem PowerShella służącym do testowania i mockowania.

## Środowisko

Na potrzeby tej prezentacji przyjmujemy wykorzystanie PowerShell w wersji 5 bądź wyższej oraz framework w wersji 5.0.0  
Informacje odnośnie wykorzystania frameworku dla wersji < 5 dostępne są na oficjalnej [stronie](https://pester.dev/) projektu.  
W momencie pisania tego README, aktualna wersja samego frameworku Pester to v5.0.0  


## Instalacja

Framework ma zastosowanie dla wersji PowerShell > 2, sprawdzamy ją komendą:

```powershell
> $PSVersionTable.PSVersion
```

Framework w wersji 3.4.0 jest dostarczany jako wbudowany komponent w systemy od Windows 10 i Windows Server 2016 w górę.  
Aktualizacja do nowszej wersji wymaga zainstalowania jej równolegle (side-by-side) komendą:

```powershell
> Install-Module -Name Pester -Force -SkipPublisherCheck
```

Aktualizacja do nowszej wersji:

```powershell
> Update-Module -Name Pester
```

Importowanie przed pierwszym użyciem:
```powershell
> Import-Module Pester -PassThru
```

## Obsługa

Pliki z testami korzystają z nazw `*.Tests.ps1`, powinny być umieszczane obok plików z testowanymi funkcjami, a ich nazwy odnosić się do nazw testowanych funkcji.  
Testy są umieszczane w blokach `It` i grupowane za pomocą `Describe` oraz `Context`. Wyrażenie `Should` określa, co jest testowane i zwróci niepowodzenie testu, czy też *Faila*, jeśli jego warunek nie zostanie spełniony.  

### Importowanie testowanych funkcji
Aby kod który chcemy przetestować był dostępny z poziomu testów, należy go zaimportować w sekcji inicjalizacji na początku pliku z testami, odwołując się poprzez ścieżkę:

```powershell
BeforeAll {
    # Przez bezpośrednie wskazanie pliku do przetestowania
    . $PSScriptRoot/ExampleCode.ps1

    # Przez podmianę nazwy aktualnego pliku z testami, metoda Replace() rozróżna wielkość znaków
    . $PSCommandPath.Replace('.Tests.ps1', '.ps1')
}
```

W tym bloku możemy również umieścić bezpośrednio funkcję do przetestowania, zamiast ścieżki odnoszącej do całego skryptu:

```powershell
BeforeAll {
    function Example-Function () {
        # Kod do przetestowania
        # ...
    }
}
```

### Struktura kodu testów

Plik testów jest podzielony na bloki `Describe` `Context` `It` `BeforeAll` `BeforeEach` `AfterAll` `AfterEach`.  
Na samym początku pliku znajduje się blok inicjalizacji `BeforeAll`, występujący przed wszystkimi testami. Zawiera on zwykle odniesienie do zaimportowanych funkcji (patrz wyżej).  
Następnie umieszcza się główny blok `Describe`, w nim będą znajdować się wszystkie kolejne bloki w całej strukturze.
Nie powinno umieszczać się kodu poza tymi dwoma blokami bez dobrze uzasadnionego powodu.  

### Przykłady
Przykładowa struktura testów:
```powershell
BeforeAll {
    Write-Host "-> Główny BeforeAll (setup)"
}

Describe "d_Opis" {
    BeforeAll {
        Write-Host "-> d_Opis BeforeAll"
    }
    BeforeEach { 
        Write-Host "-> d_Opis BeforeEach"
    }    
    Context "c_Kontekst" {
        BeforeAll {
            Write-Host "-> c_Kontekst BeforeAll"
        }
        BeforeEach { 
            Write-Host "-> c_Kontekst BeforeEach"
        }
        It "i_Test" { 
            # przykładowy test...
        }
        AfterEach { 
            Write-Host "-> c_Kontekst AfterEach"
        }
        AfterAll {
            Write-Host "-> c_Kontekst AfterAll"
        }
    }    
    AfterEach { 
        Write-Host "-> d_Opis AfterEach"
    }
    AfterAll {
        Write-Host "-> d_Opis AfterAll"
    }
}

AfterAll {
    Write-Host "-> Główny AfterAll (teardown)"
}
```
Przykładowy wynik wyświetlany w konsoli:
```powershell
Running tests from 'Example'
-> Główny BeforeAll (setup)
-> d_Opis BeforeAll
-> c_Kontekst BeforeAll
Describing d_Opis
 Context c_Kontekst
-> d_Opis BeforeEach
-> c_Kontekst BeforeEach
-> c_Kontekst AfterEach
-> d_Opis AfterEach
   [+] i_Test 89ms (86ms|4ms)
-> c_Kontekst AfterAll
-> d_Opis AfterAll
-> Główny AfterAll (teardown)
Tests completed in 543ms
Tests Passed: 1, Failed: 0, Skipped: 0 NotRun: 0
```
Pełny działający przykład znajduje się w folderze `./Example`
### Uruchamianie
Testy są uruchamiane funkcją `Invoke-Pester`, a pełne wyniki zostaną wyświetlone poprzez dodanie do niej parametru `-Output Detailed`:
```powershell
> Invoke-Pester -Output Detailed C:\Example.Tests.ps1
```

