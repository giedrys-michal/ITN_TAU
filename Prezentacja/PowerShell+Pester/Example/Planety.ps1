function Get-Planet ([string]$Name = '*') {
    $planets = @(
        @{ Name = 'Merkury' }
        @{ Name = 'Wenus'   }
        @{ Name = 'Ziemia'   }
        @{ Name = 'Mars'    }
        @{ Name = 'Jowisz' }
        @{ Name = 'Saturn'  }
        @{ Name = 'Uran'  }
        @{ Name = 'Neptun' }
    ) | ForEach-Object { [PSCustomObject] $_ }

    $planets | Where-Object { $_.Name -like $Name }
}