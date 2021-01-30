BeforeAll {
    . $PSScriptRoot/Get-Planet.ps1
}

Describe 'Get-Planet' {
    It 'Wypisuje wszystkie 8 planet' {
        $allPlanets = Get-Planet
        $allPlanets.Count | Should -Be 8
    }

    Context "Filtrowanie po nazwie Name" {
        It "Dany poprawny parametr -Name '<Filter>', zwraca '<Expected>'" -TestCases @(
            @{ Filter = 'Ziemia'; Expected = 'Ziemia' }
            @{ Filter = 'ne*'  ; Expected = 'Neptun' }
            @{ Filter = 'ur*'  ; Expected = 'Uran' }
            @{ Filter = 'm*'   ; Expected = 'Merkury', 'Mars' }
        ) {
            param ($Filter, $Expected)
            $planets = Get-Planet -Name $Filter
            $planets.Name | Should -Be $Expected
        }
        It "Dany niepoprawny parametr -Name 'Alfa Centauri', zwraca `$null" {
            $planets = Get-Planet -Name 'Alfa Centauri'
            $planets | Should -Be $null
        }
    }
}