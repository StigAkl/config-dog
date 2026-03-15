import {
  SignedIn,
  SignedOut,
  UserButton,
} from '@clerk/clerk-react'
import { Link } from '@tanstack/react-router'

export default function HeaderUser() {
  return (
    <>
      <SignedIn>
        <UserButton />
      </SignedIn>
      <SignedOut>
        <Link
          to="/sign-in"
          className="inline-flex items-center rounded-full border border-(--chip-line) bg-(--chip-bg) px-3 py-1.5 text-sm font-semibold text-sea-ink no-underline shadow-[0_8px_24px_rgba(30,90,72,0.08)] transition hover:bg-(--link-bg-hover)"
        >
          Sign in
        </Link>
      </SignedOut>
    </>
  )
}
